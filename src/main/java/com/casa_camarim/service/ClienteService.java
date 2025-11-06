package com.casa_camarim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Cliente;
import com.casa_camarim.repositories.ClienteRepository;

@Service
public class ClienteService {

	 	// Injeta automaticamente o repositório do cliente
		@Autowired
		private ClienteRepository clienteRepository;
		
		// Salva ou atualiza um cliente no banco de dados.
		public Cliente saveCliente(Cliente cliente) {
			return clienteRepository.save(cliente);
		}

		// Retorna todos os cliente cadastrados.
		public List<Cliente> getAllCliente() {
			return clienteRepository.findAll();
		}

		// Busca um cliente pelo seu ID.
		public Cliente getClienteById(Long id) {
			return clienteRepository.findById(id).orElse(null);
		}

		// Exclui um cliente pelo ID.
		public void deleteCliente(Long id) {
			clienteRepository.deleteById(id);
		}
		
		// Busca todos os agendamentos de um cliente
	    public List<Cliente> getFindClienteByTelefone(String telefone) {
	        return clienteRepository.findByTelefone(telefone);
	    }
}
