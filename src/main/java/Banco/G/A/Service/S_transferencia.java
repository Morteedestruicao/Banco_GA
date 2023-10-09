package Banco.G.A.Service;

import Banco.G.A.Model.M_Resposta;
import Banco.G.A.Model.M_Usuario;
import Banco.G.A.Repository.R_Trans;

public class S_transferencia {

    private static R_Trans r_trans;

    public S_transferencia(R_Trans r_trans) {
        this.r_trans = r_trans;
    }

    public static M_Resposta transferencia(String senha, String cpf, Long valor) {
        boolean podeSalvar = true;
        String mensagem = "";
        if (S_Generico.textoEstaVazio(S_Generico.limparNumero(cpf))) {
            podeSalvar = false;
            mensagem += "O CPF precisa ser preenchido";
        }
        if (S_Generico.textoEstaVazio(senha)) {
            podeSalvar = false;
            mensagem += "senha inválida";
        }
        if (S_Generico.textoEstaVazio(String.valueOf(valor))) {
            podeSalvar = false;
            mensagem += "Dinheiro inválido";
        }
        if(podeSalvar){
            M_Usuario m_usuario = S_Usuario.verificarLogin(cpf, senha);
            double resultado = m_usuario.getDinheiro() - valor;
            m_usuario.setDinheiro((long) resultado);
            r_trans.save(m_usuario);

        }
        M_Resposta m_resposta = new M_Resposta(podeSalvar, mensagem);
        return m_resposta;
    }
}
