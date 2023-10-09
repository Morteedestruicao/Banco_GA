$("#enviarLogin").click(validaLogin);

function validaCampoVazio(campo) {
    if (campo.trim() == '') {
        return true;
    } else {
        return false;
    }
}

function validaLogin() {
    let podeEnviar = true
    let cpf = $("#cpf").val();
    let senha = $("#senha").val();
    if (validaCampoVazio(cpf)) {
        podeEnviar = false;
    }
    if (validaCampoVazio(senha)) {
        podeEnviar = false;
    }
    if (podeEnviar) {
        $.ajax({
            type: "POST",
            url: "/",
            data: {
                cpf: cpf,
                senha: senha,
            },
            success: function (data) {
            window.location.href = "/Home";
                },
            error: function () {
                $("#errorMessage").append("Deu muito ruim parça!");
            }
        });
    }
}

