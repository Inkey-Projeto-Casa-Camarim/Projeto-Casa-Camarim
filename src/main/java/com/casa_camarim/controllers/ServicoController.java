package com.casa_camarim.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casa_camarim.entities.Servico;
import com.casa_camarim.service.ServicoService;

// Controller REST para gerenciar Serviços.
// Expõe endpoints para criar, listar, buscar por ID e deletar serviços.
@RestController
@RequestMapping("/api/servico")
@CrossOrigin(origins = "*")
public class ServicoController {
	
		// Injeta automaticamente o service do Serviço
		@Autowired
		private ServicoService servicoService;

		@PostMapping
	    public Servico saveServico(@RequestBody Servico servico) {
	        return servicoService.saveServico(servico);
	    }

	    @GetMapping
	    public List<Servico> getAllServicos() {
	        return servicoService.getAllServicos();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Servico> getServicoById(@PathVariable Long id) {
	        Optional<Servico> servico = servicoService.getServicoById(id);
	        return servico.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Servico> editServico(@PathVariable Long id, @RequestBody Servico servico) {
	        Servico servicoAtualizado = servicoService.updateServico(id, servico);
	        if (servicoAtualizado != null) {
	            return ResponseEntity.ok(servicoAtualizado);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteServico(@PathVariable Long id) {
	        if (servicoService.getServicoById(id).isPresent()) {
	            servicoService.deleteServico(id);
	            return ResponseEntity.ok().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	}