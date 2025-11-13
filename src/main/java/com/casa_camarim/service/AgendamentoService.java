package com.casa_camarim.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Agendamento;
import com.casa_camarim.entities.Cliente;
import com.casa_camarim.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    /**
     * Retorna os horários disponíveis para uma data.
     */
    public List<String> getHorariosDisponiveis(LocalDate data) {
        List<String> todosHorarios = Arrays.asList(
            "09:00", "09:30", "10:00", "10:30",
            "11:00", "11:30", "13:00", "13:30",
            "14:00", "14:30", "15:00", "15:30",
            "16:00", "16:30", "17:00", "17:30",
            "18:00"
        );

        List<Agendamento> agendamentosDoDia = agendamentoRepository.findByData(data);

        List<String> horariosOcupados = agendamentosDoDia.stream()
                .map(Agendamento::getHora)
                .collect(Collectors.toList());

        todosHorarios.removeAll(horariosOcupados);

        return todosHorarios;
    }

    /**
     * Salva um novo agendamento no banco.
     */
    public Agendamento salvarAgendamento(Cliente cliente, LocalDate data, LocalTime hora, String telefone) {
        // Verifica se o horário ainda está disponível
        List<String> horariosDisponiveis = getHorariosDisponiveis(data);
        if (!horariosDisponiveis.contains(hora)) {
            throw new RuntimeException("Horário indisponível: " + hora);
        }

        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(cliente);
        agendamento.setData(data);
        agendamento.setHora(hora);
        agendamento.setTelefone(telefone);
        agendamento.setStatus("AGENDADO"); // status inicial

        return agendamentoRepository.save(agendamento);
    }

    /**
     * Lista todos os agendamentos de um cliente pelo ID.
     */
    public List<Agendamento> getAgendamentosPorCliente(Long clienteId) {
        return agendamentoRepository.findByClienteId(clienteId);
    }

    /**
     * Lista todos os agendamentos de uma data específica.
     */
    public List<Agendamento> getAgendamentosPorData(LocalDate data) {
        return agendamentoRepository.findByData(data);
    }

    /**
     * Lista todos os agendamentos pelo telefone do cliente.
     */
    public List<Agendamento> getAgendamentosPorTelefone(String telefone) {
        return agendamentoRepository.findByTelefone(telefone);
    }

    /**
     * Atualiza o status de um agendamento (ex: "CONCLUÍDO", "CANCELADO").
     */
    public Agendamento atualizarStatus(Long agendamentoId, String status) {
        Agendamento agendamento = agendamentoRepository.findById(agendamentoId)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado: " + agendamentoId));
        agendamento.setStatus(status);
        return agendamentoRepository.save(agendamento);
    }
}
