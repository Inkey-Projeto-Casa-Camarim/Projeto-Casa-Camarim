package com.casa_camarim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Agenda;
import com.casa_camarim.repositories.AgendaRepository;

@Service
public class AgendaService {

	@Autowired // Pede pro Spring para fornecer automaticamente uma instância de AgendaRepository neste local
	private AgendaRepository agendaRepository;
	
	// Recebe um objeto (Agenda) e o salva no banco
	public Agenda saveAgenda(Agenda agenda) {
		return agendaRepository.save(agenda);
	}

	// Retorna uma lista com todas as agendas do banco de dados
	public List<Agenda> getAllAgenda() {
		return agendaRepository.findAll();
	}

	// Busca uma Agenda pelo ID
	public Agenda getAgendaById(Long id) {
		return agendaRepository.findById(id).orElse(null);
	}

	// Deleta a agenda com o ID fornecido
	public void deleteAgenda(Long id) {
		agendaRepository.deleteById(id);
	}
}