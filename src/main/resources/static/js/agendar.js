document.addEventListener("DOMContentLoaded", function () {
const form = document.getElementById("formAgendar");

// Adiciona um evento pra quando o formulário for enviado
form.addEventListener("submit", function(event) {
  event.preventDefault(); 

  const hora = document.getElementById("hora").value;
  const dia = document.getElementById("dia").value;

  // CRIA UM OBJETO COM OS DADOS
  const dados = {
    hora: hora,
    dia:dia
  };


  // Faz o envio para o backend
         fetch('http://localhost:8080/agenda', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            // Envia os dados no formato JSON
            body: JSON.stringify({

                dia: dia,
                hora: hora
            })
        })
        .then(response => {
            if (response.ok) {
                return response.json(); // Ve se deu tudo certo
            } else {
                throw new Error('Erro ao agendar. Verifique os dados e tente novamente.');
            }
        })
        .then(agendamento => {
            //Mostra que o agendamento deu certo
            alert('Agendamento realizado com sucesso para ' + agendamento.nome + '!');

            window.location.href = './confirmacoes/enviado.html';

        })
        .catch(error => {
            // Se der erro na comunicação com a API
            alert(error.message);
        });
    })

    ;
})