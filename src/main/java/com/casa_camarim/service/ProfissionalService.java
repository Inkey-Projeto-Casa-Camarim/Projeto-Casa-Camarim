package com.casa_camarim.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Profissional;

// Classe de serviço responsável pelas regras de negócio
// relacionadas aos profissionais do sistema.
@Service
public interface ProfissionalService {
	
	// Retorna todos os profissionais cadastrados
	List<Profissional> getAllProfissional();
	
	// Busca um profissional específico pelo ID
	Optional<Profissional> getProfissionalById(Long id);
	
	// Salva (cria ou atualiza) um profissional no banco de dados
	Profissional saveProfissional(Profissional profissional);
	
	// Exclui um profissional pelo ID
	void deleteProfissional(Long id);
	
	// Busca um profissional pelo CPF
	Profissional findByCpf(String cpf);
}
