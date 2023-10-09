$("#btntransferir").click(tranferencia);

function tranferencia(){
    let podeEnviar = true;
        let cpf = $("#cpf").val();
        let valor = $("#valor").val();

        if(valor == null){
            podeEnviar = false;
        }
         if(cpf == null){
            podeEnviar = false;
        }
        if(podeEnviar){
            $.ajax({
                type: "POST",
                url: "/Home",
                data:{
                    cpf: cpf,
                    valor:valor,
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

