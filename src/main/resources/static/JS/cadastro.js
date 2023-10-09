$("#btnCadastro").click(cadastrarUsuario);

function cadastrarUsuario(){
    let podeEnviar = true;
    let nome = $("#nome").val();
    let cpf = $("#cpf").val();
    let email = $("#email").val();
    let senha = $("#senha").val();
    let datanasc = $("#datanasc").val();
    let telefone = $("#telefone").val();
    let dinheiro = 0;

     if(cpf == null){
     podeEnviar = false;
     }
     if(podeEnviar){
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
             success: function (data){
             if(data.sucesso){
                alert("Deu bom!");
             }else{
             alert(data.mensagem);
                }
             },
             error: function(){
                 alert("deu ruim lek");
             }
         });
     }

}