let agendamentoParaCancelar = null;

/* ================================
   ENDPOINTS DO BACK-END
================================ */
const SERVICO_BASE = "http://localhost:8080/api/servicos";
const AGENDAMENTO_BASE = "http://localhost:8080/api/agendamentos";

/* ================================
   CACHE DE SERVIÇOS
================================ */
const servicoCache = new Map();

/* ================================
   OBTÉM NOME DO SERVIÇO
================================ */
async function obterNomeServico(a) {
    try {
        if (a.servico?.nome) return a.servico.nome;

        if (a.servicoNome) return a.servicoNome;
        if (a.nomeServico) return a.nomeServico;

        const servicoId = a.servico?.id || a.servicoId || a.servico_id;

        if (!servicoId) return "Serviço não informado";

        if (servicoCache.has(servicoId)) return servicoCache.get(servicoId);

        const res = await fetch(`${SERVICO_BASE}/${servicoId}`);
        if (!res.ok) return "Serviço não encontrado";

        const serv = await res.json();
        const nome = serv?.nome ?? "Serviço não encontrado";

        servicoCache.set(servicoId, nome);
        return nome;

    } catch (err) {
        console.error("Erro ao obter nome do serviço:", err);
        return "Serviço não encontrado";
    }
}

/* ================================
   INICIALIZAÇÃO
================================ */
document.addEventListener("DOMContentLoaded", async () => {
    console.log("=== PERFIL DO USUÁRIO CARREGADO ===");

    if (AuthService.requireAuth()) {
        preencherDadosUsuario();
        await carregarAgendamentosUsuario();
        configurarModal();
    }
});

/* ================================
   PREENCHER DADOS DO USUÁRIO
================================ */
function preencherDadosUsuario() {
    const usuario = AuthService.getUsuarioLogado();
    if (!usuario) return;

    const olaTitulo = document.querySelector(".perfil-usuario h1");
    const nomeCampo = document.querySelector(".perfil-usuario p:nth-of-type(1)");
    const telefoneCampo = document.querySelector(".perfil-usuario p:nth-of-type(2)");

    if (olaTitulo) olaTitulo.innerHTML = `Olá, <strong>${usuario.nome}</strong>`;
    if (nomeCampo) nomeCampo.innerHTML = `Nome: <strong>${usuario.nome}</strong>`;
    if (telefoneCampo) telefoneCampo.innerHTML = `Telefone: <strong>${usuario.telefone}</strong>`;
}

/* ================================
   CARREGAR AGENDAMENTOS DO USUÁRIO
================================ */
async function carregarAgendamentosUsuario() {
    try {
        const usuario = AuthService.getUsuarioLogado();
        if (!usuario?.id) throw new Error("Usuário não encontrado");

        const res = await fetch(`${AGENDAMENTO_BASE}/usuario/${usuario.id}`);
        if (!res.ok) throw new Error("Erro ao buscar agendamentos");

        const agendamentos = await res.json();
        const agendamentosDiv = document.querySelector(".agendamentos");

        if (!agendamentosDiv) return;

        if (agendamentos.length === 0) {
            agendamentosDiv.innerHTML = `<p style="text-align:center;">Você não possui agendamentos.</p>`;
            return;
        }

        // Montagem dos cards
        const itensHtml = await Promise.all(
            agendamentos.map(async (a) => {
                const nomeServico = await obterNomeServico(a);
                const dataAg = formatarData(a.data);
                const horarioAg = a.horario ? a.horario.substring(0, 5) : "Horário inválido";
                const status = a.status ?? "—";
                const id = a.id;

                return `
                    <div class="card-agendamento agendamento-item">
                        <div class="card-top">
                            <h3 class="servico-nome">${escapeHtml(nomeServico)}</h3>
                        </div>

                        <div class="card-body">
                            <p><strong>Dia:</strong> ${dataAg}</p>
                            <p><strong>Horário:</strong> ${horarioAg}</p>
                            <p><strong>Status:</strong> ${escapeHtml(status)}</p>
                        </div>

                        ${status === "AGENDADO"
                            ? `<div class="card-actions">
                                   <button onclick="abrirModal(${id})" class="btn-cancelar">Cancelar</button>
                               </div>`
                            : ""
                        }
                    </div>
                `;
            })
        );

        agendamentosDiv.innerHTML = itensHtml.join("");

    } catch (err) {
        console.error("Erro ao carregar agendamentos:", err);
        document.querySelector(".agendamentos").innerHTML =
            `<p style="color:red;">Erro ao carregar agendamentos.</p>`;
    }
}

/* ================================
   FORMATAR DATA
================================ */
function formatarData(dataString) {
    const d = new Date(dataString + "T00:00:00");
    return isNaN(d) ? "Data inválida" : d.toLocaleDateString("pt-BR");
}

/* ================================
   PROTEÇÃO HTML
================================ */
function escapeHtml(str) {
    return String(str || "")
        .replace(/&/g, "&amp;")
        .replace(/</g, "&lt;")
        .replace(/>/g, "&gt;");
}

/* ================================
   MODAL
================================ */
function configurarModal() {
    const modal = document.getElementById("modalConfirmacao");
    const btnFechar = document.getElementById("btnFecharModal");
    const btnConfirmar = document.getElementById("btnSim");

    btnFechar?.addEventListener("click", fecharModal);
    btnConfirmar?.addEventListener("click", cancelarAgendamento);

    window.addEventListener("click", (e) => {
        if (e.target === modal) fecharModal();
    });
}

function abrirModal(id) {
    agendamentoParaCancelar = id;
    document.getElementById("modalConfirmacao").style.display = "block";
}

function fecharModal() {
    document.getElementById("modalConfirmacao").style.display = "none";
    agendamentoParaCancelar = null;
}

/* ================================
   CANCELAR AGENDAMENTO (FINAL)
================================ */
async function cancelarAgendamento() {
    if (!agendamentoParaCancelar) return;

    try {
        const url = `${AGENDAMENTO_BASE}/${agendamentoParaCancelar}/cancelar`;
        const res = await fetch(url, { method: "PUT" });

        if (!res.ok) {
            const erroTxt = await res.text();
            throw new Error(`Erro ao cancelar (${res.status}): ${erroTxt}`);
        }

        fecharModal();
        await carregarAgendamentosUsuario();
        alert("Agendamento cancelado com sucesso!");

    } catch (err) {
        console.error("Erro ao cancelar:", err);
        alert("Erro ao cancelar: " + err.message);
    }
}
