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

@RestController
@RequestMapping("/servico")
public class ServicoController {
	
	@Autowired
	private ServicoService servicoService;

	//Endpoint para salvar 
	@PostMapping
	public Servico saveServico(@RequestBody Servico servico) {
		return servicoService.saveServico(servico);
	}

	//Endpoint para buscar 
	@GetMapping
	public List<Servico> getAllServico() {
		return servicoService.getAllServico();
	}

	//Endpoint para buscar usuário por ID
	@GetMapping("/{id}")
	public Servico getServicoById(@PathVariable Long id) {
		return servicoService.getServicoById(id);
	}

    //Endpoint para deletar um usuário
	@DeleteMapping("/{id}")
	public void deleteServico(@PathVariable Long id) {
		servicoService.deleteServico(id);
	}
	
}


