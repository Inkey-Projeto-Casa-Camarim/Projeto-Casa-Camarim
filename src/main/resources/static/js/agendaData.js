// agendaData.js
document.addEventListener('DOMContentLoaded', () => {
    const serviceId = sessionStorage.getItem('serviceId');
    const diaSelect = document.getElementById('dia-select');
    const horarioSelect = document.getElementById('horario-select');

    // Buscar datas do back-end
    fetch(`http://localhost:8080/agenda/datas?serviceId=${serviceId}`)
        .then(res => res.json())
        .then(datas => {
            datas.forEach(d => {
                const option = document.createElement('option');
                option.value = d;
                option.textContent = d;
                diaSelect.appendChild(option);
            });
        });

    // Atualizar horários ao selecionar dia
    diaSelect.addEventListener('change', () => {
        const dia = diaSelect.value;
        fetch(`http://localhost:8080/agenda/horarios?serviceId=${serviceId}&dia=${dia}`)
            .then(res => res.json())
            .then(horarios => {
                horarioSelect.innerHTML = '<option value="">Selecione o horário...</option>';
                horarios.forEach(h => {
                    const option = document.createElement('option');
                    option.value = h;
                    option.textContent = h;
                    horarioSelect.appendChild(option);
                });
            });
    });

    // Submissão do formulário
    document.getElementById('formAgendar').addEventListener('submit', e => {
        e.preventDefault();
        const dataSelecionada = diaSelect.value;
        const horarioSelecionado = horarioSelect.value;
        if(!dataSelecionada || !horarioSelecionado){
            alert('Selecione data e horário.');
            return;
        }
        sessionStorage.setItem('selectedData', dataSelecionada);
        sessionStorage.setItem('selectedHorario', horarioSelecionado);
        window.location.href = 'agendarUsuario.html';
    });
});
