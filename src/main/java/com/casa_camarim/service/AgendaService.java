package com.casa_camarim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Agenda;
import com.casa_camarim.repositories.AgendaRepository;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    // Salva um agendamento (cria ou atualiza)
    public Agenda saveAgenda(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    // Retorna todos os agendamentos
    public List<Agenda> getAllAgenda() {
        return agendaRepository.findAll();
    }

    // Busca um agendamento por ID
    public Agenda getAgendaById(Long id) {
        return agendaRepository.findById(id).orElse(null);
    }

    // Deleta um agendamento por ID
    public void deleteAgenda(Long id) {
        agendaRepository.deleteById(id);
    }

    // Busca todos os agendamentos de um cliente pelo telefone
    public List<Agenda> getAgendaByTelefone(String telefone) {
        return agendaRepository.findByTelefone(telefone);
    }
}
