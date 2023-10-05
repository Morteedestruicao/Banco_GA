package Banco.G.A.Controller;

import Banco.G.A.Service.S_Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Usuario {


    //Isso aqui vai pro C_Cadastro
    @GetMapping("/cadastro")
    public String getUsuario() {
        return "usuario/cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastroUsuario(@RequestParam("nome") String nome,
                                  @RequestParam("email") String email,
                                  @RequestParam("senha") String senha,
                                  @RequestParam("cpf") String cpf,
                                  @RequestParam("telefone") String telefone,
                                  @RequestParam("datanasc") String datanasc
    ) {
        S_Usuario.cadastroUsuario(nome, email, senha, cpf, telefone, datanasc);
        return "usuario/cadastro";
    }
    //-------------------------------------

    @GetMapping("/")
    public String getLogin(){
        return "login/Index";
    }

    //Esse vai pro C_Home
    @GetMapping("/Home")
    public String getHome(){
        return "home/Home";
    }
    //----------

    @PostMapping("/")
    @ResponseBody
    public boolean postLogin(@RequestParam("cpf")String cpf,
                             @RequestParam("senha")String senha,
                             HttpSession session,
                             Model model){
        session.setAttribute("usuario",S_Usuario.verificarLogin(cpf, senha));
        if(S_Usuario.verificarLogin(cpf, senha) == null){
            return false;
        }else{
            return true;
        }
    }
}
