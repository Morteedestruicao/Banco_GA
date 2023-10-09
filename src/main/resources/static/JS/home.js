$("#btntranferir").click(tranferencia);
$("#btndeposito").click(deposito);

function tranferencia(){
    let podeEnviar = true;
        let cpf = $("#cpf").val();
        let valor = $("#valor").val();
        let senha = $("#senha").val();

        if(valorTransacao == null){
            podeEnviar = false;
        }
        if(podeEnviar){
            $.ajax({
                type: "POST",
                url: "/Home",
                data:{
                    cpf: cpf,
                    senha: senha,
                    dinheiro:valor,
                },
                success: function (data){
                    if(data.sucesso){
                        alert("Deu bom!");
                    }else{
                        alert(data.mensagem);
                    }
                },
                error: function (){
                    $("#errorMessage").append("Deu muito ruim parça!");
                }
            });
        }
    }

function deposito(){
    let cpf = $("#cpf").val();
    let dinheiro = $("#valor").val();

    $.ajax({
        type: "POST",
        url: "/Home",
        data:{
            cpf:cpf,
            dinheiro:dinheiro,
        },
        success:function(){
            alert("ok");
        },
        error: function(){
            alert("deu ruim lek");
        }
    })
}
