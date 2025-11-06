package com.casa_camarim.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Agendamento;
import com.casa_camarim.entities.Cliente;

@Service
public interface ClienteService {

	 List<Cliente> getAllClientes();
	 
	    Optional<Cliente> getClienteById(Long id);
	    
	    Cliente saveCliente(Cliente usuario);
	    
	    void deleteCliente(Long id);
	    
	    Cliente getClienteByTelefone(String telefone);

	    boolean existsByTelefone(String telefone);
	    
	    Cliente login( String telefone, String nome);
	    
	    Cliente criarCliente(String nome, String telefone);
	    
	    List<Agendamento> getAgendamentosByClienteId(Long clienteId);
}
