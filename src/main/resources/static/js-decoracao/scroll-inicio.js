 const btnTopo = document.getElementById("btnTopo");

    // Mostrar/esconder botão ao rolar a página
    window.addEventListener("scroll", function () {
        if (window.scrollY > 200) {
            btnTopo.classList.add("show");
        } else {
            btnTopo.classList.remove("show");
        }
    });

    // Scroll suave personalizado
    btnTopo.addEventListener("click", function () {
        const duration = 600; // duração em ms (1 segundo, pode aumentar se quiser mais suave)
        const start = window.scrollY;
        const startTime = performance.now();

        function animateScroll(currentTime) {
            const elapsed = currentTime - startTime;
            const progress = Math.min(elapsed / duration, 1);

            // easing (suavização) – easeOutCubic
            const ease = 1 - Math.pow(1 - progress, 3);

            window.scrollTo(0, start * (1 - ease));

            if (progress < 1) {
                requestAnimationFrame(animateScroll);
            }
        }
        requestAnimationFrame(animateScroll);
    });