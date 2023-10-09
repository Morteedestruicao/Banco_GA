$("#btnCadastro").click(cadastrarUsuario);

function cadastrarUsuario(){
    let nome = $("#nome").val();
    let cpf = $("#cpf").val();
    let email = $("#email").val();
    let senha = $("#senha").val();
    let datanasc = $("#datanasc").val();
    let telefone = $("#telefone").val();
    let dinheiro = 0;

    $.ajax({
        type: "POST",
        url: "/cadastro",
        data:{
            nome:nome,
            cpf:cpf,
            email:email,
            senha:senha,
            datanasc:datanasc,
            telefone:telefone,
            dinheiro:dinheiro,
        },
        success:function(){
            alert("ok");
        },
        error: function(){
            alert("deu ruim lek");
        }
    });
}