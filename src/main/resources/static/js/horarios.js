  // ======== BUSCAR SERVIÇOS DA API ========
    async function carregarServicos() {
      try {
        const response = await fetch("http://localhost:8080/api/servico");
        if (!response.ok) {
          throw new Error("Erro ao buscar serviços: " + response.status);
        }

        const servicos = await response.json();
        const container = document.getElementById("servico-container");

        // Limpar container antes de preencher
        container.innerHTML = "";

        // Criar cards dos serviços
        servicos.forEach(servico => {
          const card = document.createElement("div");
          card.classList.add("servico-card");

          card.innerHTML = `
            <p class="nome">${servico.nome}</p>
            <p class="preco">💰 Preço: R$ ${servico.preco}</p>
            <p>🕒 Duração: ${servico.tempoServico || "Não informado"}</p>
            <p>📋 Descrição: ${servico.descricaoServico || "Sem descrição"}</p>
          `;

          container.appendChild(card);
        });

      } catch (error) {
        console.error("Erro:", error);
      }
    }

    carregarServicos();