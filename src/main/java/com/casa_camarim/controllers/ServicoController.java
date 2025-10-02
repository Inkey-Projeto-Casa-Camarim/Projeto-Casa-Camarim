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

import com.casa_camarim.entities.Servico;
import com.casa_camarim.service.ServicoService;

// Controller REST para gerenciar Serviços.
// Expõe endpoints para criar, listar, buscar por ID e deletar serviços.
@RestController
@RequestMapping("/servico")
public class ServicoController {
	
	// Injeta automaticamente o service do Serviço
	@Autowired
	private ServicoService servicoService;

	//Endpoint para salvar o serviço
	@PostMapping
	public Servico saveServico(@RequestBody Servico servico) {
		return servicoService.saveServico(servico);
	}

	//Endpoint para buscar o serviço
	@GetMapping
	public List<Servico> getAllServico() {
		return servicoService.getAllServico();
	}

	//Endpoint para buscar serviço por ID
	@GetMapping("/{id}")
	public Servico getServicoById(@PathVariable Long id) {
		return servicoService.getServicoById(id);
	}

    //Endpoint para deletar um serviço
	@DeleteMapping("/{id}")
	public void deleteServico(@PathVariable Long id) {
		servicoService.deleteServico(id);
	}
	
}


