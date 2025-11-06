package com.casa_camarim.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Servico;

// Classe de serviço responsável pelas regras de negócio
// relacionadas aos serviços oferecidos no sistema.
@Service 
public interface ServicoService {

	// Retorna todos os serviços cadastrados
	List<Servico> getAllServicos();
	
	// Busca um serviço específico pelo ID
	Optional<Servico> getServicoById(Long id);
	
	// Salva (cria ou atualiza) um serviço no banco de dados
	Servico saveServico(Servico servico);
	
	// Atualiza as informações de um serviço existente
	Servico updateServico(Long id, Servico servico);
	
	// Exclui um serviço pelo ID
	void deleteServico(Long id);
}