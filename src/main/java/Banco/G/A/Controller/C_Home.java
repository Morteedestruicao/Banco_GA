package Banco.G.A.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


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
}
