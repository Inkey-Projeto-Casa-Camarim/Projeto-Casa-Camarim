document.addEventListener('DOMContentLoaded', () => {
    const servicos = JSON.parse(sessionStorage.getItem('servicos')) || [];

    const main = document.querySelector('main') || document.body;

    servicos.forEach(s => {
        const div = document.createElement('div');
        div.classList.add('servico-agendado');
        div.innerHTML = `
            <h1>${s.nomeServico}</h1>
            <p>Data: ${s.data}</p>
            <p>Horário: ${s.horario}</p>
        `;
        main.appendChild(div);
    });
});
