 window.addEventListener("load", function () {
      const loading = document.getElementById("loading");
      const body = document.body;

      // fade-out no loading
      loading.classList.add("fade-out");

      // ativa fade-in do conteúdo
      setTimeout(() => {
        loading.style.display = "none";
        body.classList.add("loaded");
      }, 800);
    });