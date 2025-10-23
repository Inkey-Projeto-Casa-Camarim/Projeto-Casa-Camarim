package com.casa_camarim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.casa_camarim.entities.Agenda;
import com.casa_camarim.service.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

	@Autowired
	private AgendaService agendaService;

	@PostMapping
	public Agenda saveAgenda(@RequestBody Agenda agenda) {
		return agendaService.saveAgenda(agenda);
	}

	@GetMapping
	public List<Agenda> getAllAgenda() {
		return agendaService.getAllAgenda();
	}

	@GetMapping("/{id}")
	public Agenda getAgendaById(@PathVariable Long id) {
		return agendaService.getAgendaById(id);
	}

	@PutMapping
	public Agenda editAgenda(@RequestBody Agenda agenda) {
		return agendaService.saveAgenda(agenda);
	}

	@DeleteMapping("/{id}")
	public void deleteAgenda(@PathVariable Long id) {
		agendaService.deleteAgenda(id);
	}

	// 🔹 Novo endpoint: retorna apenas os horários já cadastrados no banco
	@GetMapping("/horarios")
	public List<String> getAllHoras() {
		return agendaService.getAllHoras();
	}
}
