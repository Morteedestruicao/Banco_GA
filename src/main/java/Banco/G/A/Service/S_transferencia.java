package Banco.G.A.Service;

import Banco.G.A.Model.M_Resposta;
import Banco.G.A.Model.M_Usuario;
import Banco.G.A.Repository.R_Trans;
import Banco.G.A.Repository.R_Usuario;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class S_transferencia {

    private static R_Trans r_trans;
    private static R_Usuario r_usuario;

    public S_transferencia(R_Trans r_trans,R_Usuario r_usuario) {
        this.r_trans = r_trans;
        this.r_usuario = r_usuario;
    }

    public static M_Resposta transferencia(String cpf, String valor, M_Usuario m_usuario) {
        boolean podeSalvar = true;
        String mensagem = "";
        valor = S_Generico.limparNumero(valor);
        cpf = S_Generico.limparNumero(cpf);
        if (S_Generico.textoEstaVazio(cpf)) {
            podeSalvar = false;
            mensagem += "O CPF precisa ser preenchido";
        }
        if (S_Generico.textoEstaVazio(valor)) {
            podeSalvar = false;
            mensagem += "Dinheiro inválido";
        }
        if(podeSalvar){
            double resultado = m_usuario.getDinheiro() - Long.parseLong(valor);
            m_usuario.setDinheiro((long) resultado);

            M_Usuario usuarioDestino = r_usuario.buscarPorCPF(Long.parseLong(cpf));
            double depositar = usuarioDestino.getDinheiro() + Long.parseLong(valor);
            usuarioDestino.setDinheiro((long) depositar);

            try {
                r_trans.save(m_usuario);
                r_trans.save(usuarioDestino);
                mensagem += "Deu bom";
            } catch (DataIntegrityViolationException e) {
                mensagem += "Deu n";
            }
        }
        M_Resposta m_resposta = new M_Resposta(podeSalvar, mensagem);
        return m_resposta;
    }
}
