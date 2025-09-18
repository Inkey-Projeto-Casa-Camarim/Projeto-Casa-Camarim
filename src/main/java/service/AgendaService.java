package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Agenda;
import repositories.AgendaRepository;

@Service
public class AgendaService {

	@Autowired
	private AgendaRepository agendaRepository;
	
	public Agenda saveAgenda(Agenda agenda) {
		return agendaRepository.save(agenda);
	}

	public List<Agenda> getAllAgenda() {
		return agendaRepository.findAll();
	}

	public Agenda getAgendaById(Long id) {
		return agendaRepository.findById(id).orElse(null);
	}

	public void deleteAgenda(Long id) {
		agendaRepository.deleteById(id);
	}
}