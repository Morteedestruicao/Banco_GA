package Banco.G.A.Service;

import Banco.G.A.Model.M_Usuario;
import Banco.G.A.Repository.R_Usuario;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class S_Usuario {
    private static R_Usuario r_usuario;

    public S_Usuario(R_Usuario r_usuario) {
        this.r_usuario = r_usuario;
    }

    public static M_Usuario verificarLogin(String cpf, String senha){
        cpf = S_Generico.limparNumero(cpf);

        if(S_Generico.textoEstaVazio(cpf)){
            return null;
        }
        if(S_Generico.textoEstaVazio(senha)){
            return null;
        }
        return r_usuario.buscarPorMatriculaSenha(Long.parseLong(cpf),senha);
    }

    public static String cadastroUsuario(String nome,String email,String senha,String cpf,String telefone,String datanasc) {
        boolean podeSalvar = true;
        String mensagem = "";
        if (S_Generico.textoEstaVazio(nome)) {
            podeSalvar = false;
            mensagem += "O nome precisa ser preenchido";
        }
        if (S_Generico.textoEstaVazio(email)) {
            podeSalvar = false;
            mensagem += "E-mail inválido";
        }
        if (S_Generico.textoEstaVazio(senha)) {
            podeSalvar = false;
            mensagem += "Senha inválida";
        }
        if (S_Generico.textoEstaVazio(datanasc)) {
            podeSalvar = false;
            mensagem += "data de nascimento deve ser preenchida";
        }
        if (S_Generico.textoEstaVazio(S_Generico.limparNumero(telefone))) {
            podeSalvar = false;
            mensagem += "O matricula precisa ser preenchido";
        }
        if (S_Generico.textoEstaVazio(S_Generico.limparNumero(cpf))) {
            podeSalvar = false;
            mensagem += "O cargo precisa ser preenchido";
        }

        if (podeSalvar) {
            M_Usuario m_usuario = new M_Usuario();
            m_usuario.setNome(nome);
            m_usuario.setEmail(email);
            m_usuario.setSenha(senha);
            m_usuario.setDatanasc(LocalDate.parse(datanasc));
            m_usuario.setCpf(Long.parseLong(cpf));
            m_usuario.setTelefone(Long.parseLong(telefone));

            try {
                r_usuario.save(m_usuario);
                mensagem += "Deu bom";
            } catch (DataIntegrityViolationException e) {
                mensagem += "Deu ruim";
            }
        }
        return null;
    }

}
