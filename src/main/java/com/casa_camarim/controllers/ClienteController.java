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

import com.casa_camarim.entities.Cliente;
import com.casa_camarim.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
		// Injeta automaticamente o service do Serviço
		@Autowired
		private ClienteService clienteService;

		//Endpoint para salvar o serviço
		@PostMapping
		public Cliente saveCliente(@RequestBody Cliente cliente) {
			return clienteService.saveCliente(cliente);
		}

		//Endpoint para buscar o serviço
		@GetMapping
		public List<Cliente> getAllCliente() {
			return clienteService.getAllCliente();
		}

		//Endpoint para buscar serviço por ID
		@GetMapping("/{id}")
		public Cliente getClienteById(@PathVariable Long id) {
			return clienteService.getClienteById(id);
		}
		
		// Endpoint para editar os serviços
		@PutMapping
		public Cliente editCliente(@RequestBody Cliente cliente) {
			return clienteService.saveCliente(cliente);
		}

	    //Endpoint para deletar um serviço
		@DeleteMapping("/{id}")
		public void deleteCliente(@PathVariable Long id) {
			clienteService.deleteCliente(id);
		}
		
		 // Buscar todos os agendamentos de um cliente pelo id
	    @GetMapping("/id/{id}")
	    public List<Cliente> getFindClienteByTelefone(@PathVariable String telefone) {
	        return clienteService.getFindClienteByTelefone(telefone);
	    }
		
	}

