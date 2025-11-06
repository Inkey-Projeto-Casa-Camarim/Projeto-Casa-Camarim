package com.casa_camarim.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Agendamento;

@Service
public interface AgendamentoService {

	 List<Agendamento> getAllAgendamentos();
	 
	    Optional<Agendamento> getAgendamentoById(Long id_agendamento);
	    
	    Agendamento saveAgendamento(Agendamento agendamento);
	    
	    Agendamento updateAgendamento(Long id_agendamento, Agendamento agendamento);
	    
	    void deleteAgendamento(Long id_agendamento);
	    
	    List<Agendamento> getAgendamentosByTelefone(String telefone);
	    
	    List<Agendamento> getAgendamentosByClienteId(Long clienteId);
	    
	    List<Agendamento> getAgendamentosByClienteIdOrTelefone(Long clienteId, String telefone);
	    
	    Agendamento criarAgendamentoComCliente(Agendamento agendamento, Long clienteId);
	    
	    List<Agendamento> getAgendamentosByStatus(String status);
}

