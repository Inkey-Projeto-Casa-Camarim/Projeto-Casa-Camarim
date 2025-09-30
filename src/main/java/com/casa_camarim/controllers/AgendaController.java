package com.casa_camarim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casa_camarim.entities.Agenda;
import com.casa_camarim.service.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

	@Autowired
	private AgendaService agendaService;

	//Endpoint para salvar 
	@PostMapping
	public Agenda saveAgenda(@RequestBody Agenda agenda) {
		return agendaService.saveAgenda(agenda);
	}

	//Endpoint para buscar 
	@GetMapping
	public List<Agenda> getAllAgenda() {
		return agendaService.getAllAgenda();
	}

	//Endpoint para buscar usuário por ID
	@GetMapping("/{id}")
	public Agenda getAgendaById(@PathVariable Long id) {
		return agendaService.getAgendaById(id);
	}

    //Endpoint para deletar um usuário
	@DeleteMapping("/{id}")
	public void deleteAgenda(@PathVariable Long id) {
		agendaService.deleteAgenda(id);
	}
	
}


