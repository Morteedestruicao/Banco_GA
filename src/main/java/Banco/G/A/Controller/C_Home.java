package Banco.G.A.Controller;

import Banco.G.A.Model.M_Resposta;
import Banco.G.A.Model.M_Usuario;
import Banco.G.A.Service.S_transferencia;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Home {
    @GetMapping("/Home")
    public String getHome(HttpSession session, Model model){
        if(session.getAttribute("usuario") != null){
            model.addAttribute("usuario",session.getAttribute("usuario"));
            return "home/Home";
        }else{
            return "redirect:/";
        }
    }

    @PostMapping("/Home")
    @ResponseBody
    public M_Resposta postLogin(@RequestParam("cpf") String cpf,
                             @RequestParam("valor") String valor, HttpSession session){
        Object usuario = session.getAttribute("usuario");
        if(usuario == null){
            return new M_Resposta(false, "Sua sessão expirou, faça login " +
                    "novamente para poder efetuar transações");
        }else{
            S_transferencia.transferencia(cpf,valor,(M_Usuario) usuario);
            return null;
        }
    }
}
