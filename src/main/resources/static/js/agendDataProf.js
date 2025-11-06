// Espera o carregamento completo do HTML antes de executar o JavaScript
document.addEventListener('DOMContentLoaded', () => {

 const BASE_URL = 'http://localhost:8080/api/agenda'; // 🧩 URL do seu endpoint

    //Garante que o usuário está logado antes de poder agendar
    const clienteId = sessionStorage.getItem('clienteId');
    if (!clienteId) {
        alert("Você precisa estar logado para agendar!");
        window.location.href = "login.html"; // 🧩 Nome página de login
        return;
    }

    //  Obtém o ID do serviço selecionado anteriormente
    const servicoId = sessionStorage.getItem('servicoId');
    if (!servicoId) {
        alert("Serviço não identificado. Escolha um serviço antes de agendar.");
        window.location.href = "servicos.html"; // 🧩 Nome página de serviços
        return;
    }

    // SELEÇÃO DE ELEMENTOS HTML

    // IDs precisam existir no seu HTML:
    // Exemplo:
    // <select id="dia-select"></select>
    // <select id="horario-select"></select>
    // <form id="formAgendar"></form>
    const diaSelect = document.getElementById('dia-select'); // 🧩 ID é o mesmo no HTML
    const horarioSelect = document.getElementById('horario-select'); // 🧩 ID é o mesmo no HTML
    const formAgendar = document.getElementById('formAgendar'); // 🧩 ID é o mesmo no HTML

    //CARREGAR DATAS DISPONÍVEIS
    async function carregarDatas() {
        try {
            // Faz a requisição ao backend para obter as datas disponíveis
            const response = await fetch(`${BASE_URL}/datas?serviceId=${servicoId}`);
            if (!response.ok) throw new Error('Erro ao carregar datas');
            const datas = await response.json();

            // Preenche o <select> de datas
            datas.forEach(data => {
                const option = document.createElement('option');
                option.value = data; // valor enviado ao backend
                option.textContent = new Date(data).toLocaleDateString('pt-BR'); // exibe a data formatada
                diaSelect.appendChild(option);
            });
        } catch (error) {
            console.error(error);
            alert('Erro ao carregar as datas disponíveis.');
        }
    }


    // CARREGAR HORÁRIOS AO ESCOLHER DATA
    async function carregarHorarios(dataSelecionada) {
        // Limpa as opções anteriores
        horarioSelect.innerHTML = '<option value="">Selecione o horário...</option>';
        try {
            // Busca os horários disponíveis no backend
            const response = await fetch(`${BASE_URL}/horarios?serviceId=${servicoId}&dia=${dataSelecionada}`);
            if (!response.ok) throw new Error('Erro ao carregar horários');
            const horarios = await response.json();

            // Caso o backend não tenha endpoint de horários,
            // você pode gerar automaticamente assim:
            // const horarios = Array.from({ length: 9 }, (_, i) => `${8 + i}:00`);

            // Preenche o select de horários
            horarios.forEach(h => {
                const option = document.createElement('option');
                option.value = h;
                option.textContent = h;
                horarioSelect.appendChild(option);
            });
        } catch (error) {
            console.error(error);
            alert('Erro ao carregar os horários disponíveis.');
        }
    }

    // Quando o usuário escolhe uma data, carrega os horários correspondentes
    diaSelect.addEventListener('change', e => {
        const dataSelecionada = e.target.value;
        if (dataSelecionada) carregarHorarios(dataSelecionada);
    });

    // ENVIAR AGENDAMENTO 
    formAgendar.addEventListener('submit', async e => {
        e.preventDefault(); // impede o envio tradicional do formulário

        const dataSelecionada = diaSelect.value;
        const horarioSelecionado = horarioSelect.value;

        if (!dataSelecionada || !horarioSelecionado) {
            alert('Selecione o dia e horário antes de agendar!');
            return;
        }

        // Corpo da requisição conforme a estrutura do backend
        const agendamento = {
            cliente: { id_cliente: clienteId }, // 🧩 confirme se o nome do campo é "id_cliente"
            servico: { id_servico: servicoId }, // 🧩 confirme se o nome do campo é "id_servico"
            data_agenda: dataSelecionada,       // 🧩 confirme o nome do campo no backend
            hora: horarioSelecionado             // 🧩 confirme o nome do campo no backend
        };

        try {
            const response = await fetch(`${BASE_URL}`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(agendamento)
            });

            if (!response.ok) throw new Error('Erro ao enviar agendamento');
            const resultado = await response.json();

            alert(`Agendamento realizado com sucesso!`);
            console.log('Agendamento salvo:', resultado);

            // Salva o último agendamento no navegador
            sessionStorage.setItem('ultimoAgendamento', JSON.stringify(resultado));

            // Redireciona o usuário após agendar
            window.location.href = 'agendarUsuario.html'; // 🧩 Nome da página de confirmação
        } catch (error) {
            console.error(error);
            alert('Erro ao salvar o agendamento. Tente novamente.');
        }
    });

    carregarDatas();
});
