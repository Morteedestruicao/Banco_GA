package Banco.G.A.Service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class S_Generico {
    public static boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean textoEstaVazio(String texto) {
        return texto == null || texto.trim().equals("");
    }

    public static String limpar(String numero) {
        // Usa expressão regular para remover caracteres não numéricos
        String numeroLimpo = numero.replaceAll("[^0-9]", "");

        return numeroLimpo;
    }

    public static String limparNumero(String number) {
        return number.replaceAll("[^0-9]", "");
    }
}
