 // Seleciona todos os serviços e adiciona evento em cada botão
        document.querySelectorAll(".servicos").forEach(servico => {
            const botao = servico.querySelector(".agendar");
            botao.addEventListener("click", () => {
                servico.classList.toggle("active");
            });
        });