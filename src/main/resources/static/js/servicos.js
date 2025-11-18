class ServicoService {
    static BASE_URL = 'http://localhost:8080/api/servicos';

    static async listarServicos() {
        try {
            const response = await fetch(this.BASE_URL);
            if (!response.ok) {
                throw new Error(`Erro ${response.status}: ${response.statusText}`);
            }
            return await response.json();
        } catch (error) {
            console.error('Erro ao buscar serviços:', error);
            throw new Error('Não foi possível carregar os serviços. Verifique sua conexão.');
        }
    }
}

// Aguarda o DOM carregar completamente
document.addEventListener('DOMContentLoaded', async function() {
    console.log('DOM carregado, iniciando carregamento de serviços...');

    // Verificar autenticação apenas se necessário
    if (typeof AuthService !== 'undefined' && AuthService.isLoggedIn) {
        if (!AuthService.isLoggedIn()) {
            console.log('Usuário não logado, redirecionando...');
            window.location.href = 'userLogin.html';
            return;
        }
    }

    await carregarServicos();
});

async function carregarServicos() {
    try {
        console.log('Iniciando carregamento de serviços...');
        const servicos = await ServicoService.listarServicos();
        console.log('Serviços carregados:', servicos);

        const mainElement = document.querySelector('main');
        if (!mainElement) {
            console.error('Elemento main não encontrado!');
            return;
        }

        // Limpar conteúdo de loading
        mainElement.innerHTML = '';

        if (servicos.length === 0) {
            mainElement.innerHTML = '<div class="erro">Nenhum serviço disponível no momento.</div>';
            return;
        }

        // Adicionar serviços dinamicamente
        servicos.forEach(servico => {

            const servicoDiv = document.createElement('div');
            servicoDiv.className = 'servicos';
            servicoDiv.innerHTML = `
                <div class="info">
                    <h1>${servico.nome}</h1>
                    <h2><i class="fa-solid fa-clock"></i> ${servico.duracaoMinutos}</h2>
                    <p>Valor - ${servico.preco}</p>
                </div>
                <button class="agendar" onclick="selecionarServico(${servico.id})">AGENDAR</button>
            `;
            mainElement.appendChild(servicoDiv);
        });

        console.log('Serviços renderizados com sucesso!');

    } catch (error) {
        console.error('Erro ao carregar serviços:', error);

        const mainElement = document.querySelector('main');
        if (mainElement) {
            mainElement.innerHTML = `
                <div class="erro">
                    <p>Erro ao carregar serviços: ${error.message}</p>
                    <button onclick="carregarServicos()" style="margin-top: 1rem; padding: 0.5rem 1rem; background: #8B7355; color: white; border: none; border-radius: 5px; cursor: pointer;">
                        Tentar Novamente
                    </button>
                </div>
            `;
        }
    }
}

function selecionarServico(servicoId) {
    console.log('Serviço selecionado:', servicoId);

    // Verificar login
    if (typeof AuthService !== 'undefined' && AuthService.isLoggedIn) {
        if (!AuthService.isLoggedIn()) {
            alert('Faça login para agendar um serviço!');
            window.location.href = 'userLogin.html';
            return;
        }
    }

    localStorage.setItem('servicoSelecionado', servicoId);
    window.location.href = 'agendarData.html';
}
