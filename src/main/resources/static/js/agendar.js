// Pega o formulário pelo ID
const form = document.getElementById("formAgendar");

// Adiciona um evento pra quando o formulário for enviado
form.addEventListener("submit", function(event) {
  event.preventDefault(); 

  const nome = document.getElementById("nome").value;
  const telefone = document.getElementById("telefone").value;
  const horario = document.getElementById("horario").value;
  const dia = document.getElementById("dia").value;

  // CRIA UM OBJETO COM OS DADOS
  const dados = {
    nome: nome,
    telefone: telefone,
    horario: horario,
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
                nome: nome,
                telefone: telefone,
                dia: dia,
                horario: horario
            })
        })
        .then(response => {
            if (response.ok) {
                return response.json(); // Se deu tudo certo
            } else {
                throw new Error('Erro ao agendar. Verifique os dados e tente novamente.');
            }
        })
        .then(agendamento => {
            // Aqui você pode mostrar uma mensagem e redirecionar
            alert('Agendamento realizado com sucesso para ' + agendamento.nome + '!');

            // 👉 Troque o caminho abaixo para a sua página de confirmação
            window.location.href = 'confirmacoes/enviado.html';
        })
        .catch(error => {
            // Se der erro na comunicação com a API
            alert(error.message);
        });
    });
