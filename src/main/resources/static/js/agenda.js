// agenda.js
document.querySelector('form').addEventListener('submit', e => {
    e.preventDefault();
    const telefone = e.target.querySelector('input').value;

    if(!telefone){
        alert('Digite um telefone.');
        return;
    }

    fetch(`http://localhost:8080/agenda/telefone/${telefone}`)
        .then(res => res.json())
        .then(agendas => {
            sessionStorage.setItem('servicos', JSON.stringify(agendas));
            window.location.href = 'usuario-servicos.html';
        })
        .catch(err => console.error(err));
});
