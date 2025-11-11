package com.casa_camarim.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Agendamento;
import com.casa_camarim.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    // Salva um agendamento (cria ou atualiza)
    public Agendamento saveAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    // Retorna todos os agendamentos
    public List<Agendamento> getAllAgendamento() {
        return agendamentoRepository.findAll();
    }

    // Busca um agendamento por ID
    public Agendamento getAgendamentoById(Long id) {
        return agendamentoRepository.findById(id).orElse(null);
    }

    // Deleta um agendamento por ID
    public void deleteAgendamento(Long id) {
        agendamentoRepository.deleteById(id);
    }

    // Busca todos os agendamentos de um cliente
    public List<Agendamento> getAgendamentoByClienteId(Long clienteId) {
        return agendamentoRepository.findByClienteId(clienteId);
    }
    
    public List<Agendamento> getFindByStatus(String status) {
        return agendamentoRepository.findByStatus(status);
    }
    
    public List<Agendamento> getFindByTelefone(String telefone) {
        return agendamentoRepository.findByTelefone(telefone);
    }
    
 // Busca todos os agendamentos de uma data específica
    public List<Agendamento> getAgendamentosPorData(String data) {
        LocalDate localDate = LocalDate.parse(data);
        return agendamentoRepository.findByData(localDate);
    }

}