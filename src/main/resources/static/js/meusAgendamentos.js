// Espera o carregamento completo da página
document.addEventListener('DOMContentLoaded', () => {

    const BASE_URL = 'http://localhost:8080/api'; // 🧩 URL base do backend
    const formBuscar = document.getElementById('formBuscarCliente');
    const telefoneInput = document.getElementById('telefone');
    const resultadosDiv = document.getElementById('resultadosAgendamentos');

    // Quando o formulário for enviado
    formBuscar.addEventListener('submit', async (e) => {
        e.preventDefault();
        const telefone = telefoneInput.value.trim();

        if (!telefone) {
            alert("Por favor, insira o número de telefone.");
            return;
        }

        try {
            // Buscar o cliente pelo telefone
            const clienteResponse = await fetch(`${BASE_URL}/usuario/telefone/${telefone}`);
            if (!clienteResponse.ok) throw new Error('Cliente não encontrado.');
            
            const cliente = await clienteResponse.json();
            const clienteId = cliente.id_usuario; // 🧩 confirme o nome do campo no seu backend

            // Buscar agendamentos do cliente
            const agendamentosResponse = await fetch(`${BASE_URL}/agenda/cliente/${clienteId}`);
            if (!agendamentosResponse.ok) throw new Error('Erro ao buscar agendamentos.');
            
            const agendamentos = await agendamentosResponse.json();

            // Exibir os agendamentos na tela
            mostrarAgendamentos(cliente, agendamentos);

        } catch (error) {
            console.error(error);
            resultadosDiv.innerHTML = `<p style="color:red;">${error.message}</p>`;
        }
    });

    // Função para exibir os agendamentos
    function mostrarAgendamentos(cliente, agendamentos) {
        resultadosDiv.innerHTML = `
            <h3>Agendamentos de ${cliente.nome}</h3>
            <p><strong>Telefone:</strong> ${cliente.telefone}</p>
            <hr>
        `;

        if (agendamentos.length === 0) {
            resultadosDiv.innerHTML += `<p>Nenhum agendamento encontrado.</p>`;
            return;
        }

        agendamentos.forEach(a => {
            const data = new Date(a.data_agenda).toLocaleDateString('pt-BR');
            const hora = a.hora;
            const servico = a.servico?.nome_servico || "Serviço não informado";
            const profissional = a.servico?.profissional?.nome || "Profissional não informado";


            // código está criando dinamicamente um bloco HTML
            // que mostra as informações de cada agendamento do cliente.
            // Ele usa o innerHTML += para adicionar cada resultado dentro da div principal
            resultadosDiv.innerHTML += `
                <div class="agendamento-item">
                    <p><strong>Data:</strong> ${data}</p> //Mostra a data do agendamento
                    <p><strong>Hora:</strong> ${hora}</p> //Mostra o horario do agendamento
                    <p><strong>Serviço:</strong> ${servico}</p> //Mostra o servico que vai ser realizado           
                    <p><strong>Profissional:</strong> ${profissional}</p> //Mostra quem vai fazer o servico
                    <hr>
                </div>
            `;
        });
    }

});
