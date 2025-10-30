// horários.js
document.querySelectorAll('.agendar').forEach(link => {
    link.addEventListener('click', function(e) {
        e.preventDefault();
        const serviceId = this.getAttribute('href').split('id=')[1];
        sessionStorage.setItem('serviceId', serviceId); // salva ID do serviço
        window.location.href = 'agendarData.html';
    });
});
