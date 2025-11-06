package com.casa_camarim.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Agendamento;

// Classe de serviço responsável por conter as regras de negócio
// relacionadas aos agendamentos do sistema.
@Service
public interface AgendamentoService {

	// Retorna todos os agendamentos cadastrados
	List<Agendamento> getAllAgendamentos();
	
	// Busca um agendamento específico pelo ID
	Optional<Agendamento> getAgendamentoById(Long id_agendamento);
	
	// Salva (cria) um novo agendamento no banco de dados
	Agendamento saveAgendamento(Agendamento agendamento);
	
	// Atualiza os dados de um agendamento existente com base no ID
	Agendamento updateAgendamento(Long id_agendamento, Agendamento agendamento);
	
	// Exclui um agendamento do banco de dados pelo ID
	void deleteAgendamento(Long id_agendamento);
	
	// Retorna todos os agendamentos associados a um número de telefone específico
	List<Agendamento> getAgendamentosByTelefone(String telefone);
	
	// Retorna todos os agendamentos de um cliente pelo seu ID
	List<Agendamento> getAgendamentosByClienteId(Long clienteId);
	
	// Busca agendamentos tanto pelo ID do cliente quanto pelo telefone
	List<Agendamento> getAgendamentosByClienteIdOrTelefone(Long clienteId, String telefone);
	
	// Cria um novo agendamento já vinculado a um cliente existente
	Agendamento criarAgendamentoComCliente(Agendamento agendamento, Long clienteId);
	
	// Retorna todos os agendamentos filtrados por status (ex: "Concluído", "Pendente")
	List<Agendamento> getAgendamentosByStatus(String status);
}