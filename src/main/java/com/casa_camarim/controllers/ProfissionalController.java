package com.casa_camarim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casa_camarim.entities.Profissional;
import com.casa_camarim.service.ProfissionalService;

@RestController
@RequestMapping("/api/profissional")
public class ProfissionalController {

			// Injeta automaticamente o service do Serviço
			@Autowired
			private ProfissionalService profissionalService;

			//Endpoint para salvar o serviço
			@PostMapping
			public Profissional saveProfissional(@RequestBody Profissional profissional) {
				return profissionalService.saveProfissional(profissional);
			}

			//Endpoint para buscar o serviço
			@GetMapping
			public List<Profissional> getAllProfissional() {
				return profissionalService.getAllProfissional();
			}

			//Endpoint para buscar serviço por ID
			@GetMapping("/{id}")
			public Profissional getProfissionalById(@PathVariable Long id) {
				return profissionalService.getProfissionalById(id);
			}
			
			// Endpoint para editar os serviços
			@PutMapping
			public Profissional editProfissional(@RequestBody Profissional profissional) {
				return profissionalService.saveProfissional(profissional);
			}

		    //Endpoint para deletar um serviço
			@DeleteMapping("/{id}")
			public void deleteProfissional(@PathVariable Long id) {
				profissionalService.deleteProfissional(id);
			}
			
			 // Buscar todos
		    @GetMapping("/id/{id}")
		    public List<Profissional> getProfissionalByCpf(@PathVariable String cpf) {
		        return profissionalService.getProfissionalByCpf(cpf);
		    }
}
