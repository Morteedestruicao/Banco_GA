package Banco.G.A.Controller;

import Banco.G.A.Service.S_Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class C_Cadastro {
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
        return S_Usuario.cadastroUsuario(nome, email, senha, cpf, telefone, datanasc);
    }
}
