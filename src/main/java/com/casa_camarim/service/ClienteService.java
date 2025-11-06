package com.casa_camarim.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Agendamento;
import com.casa_camarim.entities.Cliente;

// Classe de serviço responsável pelas regras de negócio
// relacionadas aos clientes do sistema.
@Service
public interface ClienteService {

	// Retorna todos os clientes cadastrados
	List<Cliente> getAllClientes();
	
	// Busca um cliente específico pelo ID
	Optional<Cliente> getClienteById(Long id);
	
	// Salva (cria ou atualiza) um cliente no banco de dados
	Cliente saveCliente(Cliente usuario);
	
	// Exclui um cliente pelo ID
	void deleteCliente(Long id);
	
	// Busca um cliente pelo número de telefone
	Cliente getClienteByTelefone(String telefone);

	// Verifica se já existe um cliente cadastrado com determinado telefone
	boolean existsByTelefone(String telefone);
	
	// Realiza o "login" de um cliente, verificando nome e telefone
	Cliente login(String telefone, String nome);
	
	// Cria um novo cliente com nome e telefone informados
	Cliente criarCliente(String nome, String telefone);
	
	// Retorna todos os agendamentos vinculados a um cliente específico
	List<Agendamento> getAgendamentosByClienteId(Long clienteId);
}