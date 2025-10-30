document.addEventListener('DOMContentLoaded', () => {
    const serviceId = sessionStorage.getItem('serviceId');
    const data = sessionStorage.getItem('selectedData');
    const horario = sessionStorage.getItem('selectedHorario');

    document.getElementById('formAgendar').addEventListener('submit', e => {
        e.preventDefault();

        const nome = document.getElementById('nome').value;
        const telefone = document.getElementById('telefone').value;

        fetch('http://localhost:8080/api/agendar', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                serviceId,
                nome,
                telefone,
                data,
                horario
            })
        })
        .then(res => res.json())
        .then(response => {
            if(response.success){
                window.location.href = './confirmacoes/enviado.html';
            } else {
                alert('Erro ao agendar. Tente novamente.');
            }
        })
        .catch(err => console.error(err));
    });
});
