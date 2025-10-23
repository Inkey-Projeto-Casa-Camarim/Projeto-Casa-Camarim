// document.addEventListener("DOMContentLoaded", () => {
//     const diaSelect = document.getElementById("dia-select");
//     const horarioSelect = document.getElementById("horario-select");

//     // 🔹 Busca os dados da agenda no backend
//     fetch("http://localhost:8080/agenda/listar")
//         .then(response => {
//             if (!response.ok) {
//                 throw new Error("Erro ao buscar dados da agenda");
//             }
//             return response.json();
//         })
//         .then(agendas => {
//             // Cria conjuntos para armazenar valores únicos
//             const diasUnicos = [...new Set(agendas.map(a => a.data_agenda))];

//             // Popula o select de dias
//             diasUnicos.forEach(dia => {
//                 const option = document.createElement("option");
//                 option.value = dia;
//                 option.textContent = dia;
//                 diaSelect.appendChild(option);
//             });

//             // Quando o dia for selecionado, carrega apenas os horários correspondentes
//             diaSelect.addEventListener("change", () => {
//                 const diaSelecionado = diaSelect.value;

//                 // Limpa os horários anteriores
//                 horarioSelect.innerHTML = '<option value="">Selecione o horário...</option>';

//                 // Filtra horários do dia escolhido
//                 const horariosFiltrados = agendas
//                     .filter(a => a.data_agenda === diaSelecionado)
//                     .map(a => a.hora);

//                 // Adiciona os horários filtrados no select
//                 horariosFiltrados.forEach(hora => {
//                     const option = document.createElement("option");
//                     option.value = hora;
//                     option.textContent = hora;
//                     horarioSelect.appendChild(option);
//                 });
//             });
//         })
//         .catch(error => {
//             console.error("Erro ao carregar dados da agenda:", error);
//         });
// });

document.addEventListener("DOMContentLoaded", () => {
  const selectHora = document.getElementById("select-hora");

  // Faz a requisição para o endpoint que criamos no Spring Boot
  fetch("http://localhost:8080/agenda/horarios")
    .then(response => {
      if (!response.ok) throw new Error("Erro ao carregar horários");
      return response.json();
    })
    .then(horarios => {
      // Limpa o select, mantendo apenas a opção inicial
      selectHora.innerHTML = '<option value="">Selecione um horário</option>';

      // Preenche dinamicamente com os horários vindos do banco
      horarios.forEach(hora => {
        const option = document.createElement("option");
        option.value = hora;
        option.textContent = hora;
        selectHora.appendChild(option);
      });
    })
    .catch(error => {
      console.error("Erro:", error);
      // Em caso de erro, mostra uma opção de fallback
      selectHora.innerHTML = '<option value="">Erro ao carregar horários</option>';
    });
});


