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

    @GetMapping("/")
    public String getLogin(){
        return "login/index";
    }

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
