class AgendamentoService {
    static BASE_URL = 'http://localhost:8080/api/agendamentos';

    static async agendar(usuarioId, servicoId, data, horario, telefone) {
        const response = await fetch(this.BASE_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ 
                usuarioId, 
                servicoId, 
                data, 
                horario,
                telefone 
            })
        });
        
        if (!response.ok) {
            const error = await response.text();
            throw new Error(error);
        }
        
        return await response.json();
    }
    
    static async cancelarAgendamento(agendamentoId) {
        const response = await fetch(`${this.BASE_URL}/${agendamentoId}/cancelar`, {
            method: 'PUT'
        });
        
        if (!response.ok) {
            const error = await response.text();
            throw new Error(error);
        }
    }
    
    static async listarAgendamentosUsuario(usuarioId) {
        const response = await fetch(`${this.BASE_URL}/usuario/${usuarioId}`);
        if (!response.ok) {
            throw new Error('Erro ao carregar agendamentos');
        }
        return await response.json();
    }
    
    static async listarTodosAgendamentos() {
        const response = await fetch(`${this.BASE_URL}/admin`);
        if (!response.ok) {
            throw new Error('Erro ao carregar agendamentos');
        }
        return await response.json();
    }
    
    static async listarHorariosDisponiveis(servicoId, data) {
        const response = await fetch(`${this.BASE_URL}/horarios-disponiveis?servicoId=${servicoId}&data=${data}`);
        if (!response.ok) {
            throw new Error('Erro ao carregar horários disponíveis');
        }
        return await response.json();
    }
}

// Serviço para verificação de usuário no agendamento
class AgendarAuthService {
    static BASE_URL = 'http://localhost:8080/api/agendar-auth';

    static async verificarUsuario(telefone) {
        const response = await fetch(`${this.BASE_URL}/verificar`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ telefone })
        });
        
        if (!response.ok) {
            throw new Error('Erro ao verificar usuário');
        }
        
        return await response.json();
    }
}

// Inicialização da página de agendamento
document.addEventListener('DOMContentLoaded', async function() {
    if (window.location.pathname.includes('agendarData.html')) {
        await inicializarPaginaAgendamento();
    }
});

async function inicializarPaginaAgendamento() {
    const servicoId = localStorage.getItem('servicoSelecionado');
    if (!servicoId) {
        window.location.href = 'servicos.html';
        return;
    }
    
    // Configurar data mínima como hoje
    const dataInput = document.getElementById('data');
    const hoje = new Date().toISOString().split('T')[0];
    dataInput.min = hoje;
    dataInput.value = hoje;
    
    // Carregar horários para a data atual
    await carregarHorariosDisponiveis(servicoId, hoje);
    
    // Event listener para mudança de data
    dataInput.addEventListener('change', async function() {
        await carregarHorariosDisponiveis(servicoId, this.value);
    });
    
    // Configurar submit do formulário
    document.getElementById('formAgendar').addEventListener('submit', async function(e) {
        e.preventDefault();
        await finalizarAgendamento(servicoId);
    });
}

async function carregarHorariosDisponiveis(servicoId, data) {
    try {
        const horarios = await AgendamentoService.listarHorariosDisponiveis(servicoId, data);
        const horariosContainer = document.getElementById('horarios-container');
        
        if (horarios.length === 0) {
            horariosContainer.innerHTML = '<p class="sem-horarios">Não há horários disponíveis para esta data.</p>';
            return;
        }
        
        horariosContainer.innerHTML = horarios.map(horario => `
            <div class="horario-option">
                <input type="radio" id="horario-${horario}" name="horario" value="${horario}" required>
                <label for="horario-${horario}">${horario}</label>
            </div>
        `).join('');
        
    } catch (error) {
        console.error('Erro ao carregar horários:', error);
        document.getElementById('horarios-container').innerHTML = 
            '<p class="erro">Erro ao carregar horários. Tente novamente.</p>';
    }
}

async function finalizarAgendamento(servicoId) {
    try {
        const usuario = AuthService.getUsuarioLogado();
        const formData = new FormData(document.getElementById('formAgendar'));
        const data = formData.get('data');
        const horario = formData.get('horario');
        
        if (!horario) {
            alert('Por favor, selecione um horário.');
            return;
        }
        
        let usuarioId = null;
        let telefone = '';
        
        if (usuario) {
            // Usuário logado
            usuarioId = usuario.id;
            telefone = usuario.telefone;
        } else {
            // Usuário não logado - redirecionar para cadastro/login
            const telefoneInput = prompt('Para continuar com o agendamento, informe seu telefone:');
            if (!telefoneInput) {
                alert('É necessário informar um telefone para realizar o agendamento.');
                return;
            }
            
            // Verificar se o usuário existe
            try {
                const verificarUsuario = await AgendarAuthService.verificarUsuario(telefoneInput);
                telefone = telefoneInput;
                
                if (verificarUsuario.existe) {
                    // Usuário existe - perguntar se quer fazer login
                    if (confirm('Já existe uma conta com este telefone. Deseja fazer login?')) {
                        window.location.href = 'userLogin.html';
                        return;
                    }
                } else {
                    // Usuário não existe - oferecer cadastro
                    if (confirm('Não encontramos uma conta com este telefone. Deseja se cadastrar?')) {
                        window.location.href = 'cadastroUsuario.html';
                        return;
                    }
                }
            } catch (error) {
                console.error('Erro ao verificar usuário:', error);
                telefone = telefoneInput;
            }
        }
        
        // Realizar o agendamento
        await AgendamentoService.agendar(usuarioId, parseInt(servicoId), data, horario, telefone);
        
        alert('Agendamento realizado com sucesso!');
        localStorage.removeItem('servicoSelecionado');
        
        // Redirecionar conforme situação do usuário
        if (usuario) {
            window.location.href = 'agendamentos.html';
        } else {
            window.location.href = 'servicos.html';
        }
        
    } catch (error) {
        alert('Erro ao realizar agendamento: ' + error.message);
    }
}