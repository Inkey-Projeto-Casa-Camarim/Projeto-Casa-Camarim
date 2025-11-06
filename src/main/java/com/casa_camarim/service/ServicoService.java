package com.casa_camarim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Servico;
import com.casa_camarim.repositories.ServicoRepository;

//Indica ao Spring que esta classe é um serviço e deve ser gerenciada pelo container
@Service 
public class ServicoService {

	 // Injeta automaticamente o repositório do Serviço
	@Autowired
	private ServicoRepository servicoRepository;
	
	// Salva ou atualiza um serviço no banco de dados.
	public Servico saveServico(Servico servico) {
		return servicoRepository.save(servico);
	}

	// Retorna todos os serviços cadastrados.
	public List<Servico> getAllServico() {
		return servicoRepository.findAll();
	}

	// Busca um serviço pelo seu ID.
	public Servico getServicoById(Long id) {
		return servicoRepository.findById(id).orElse(null);
	}

	// Exclui um serviço pelo ID.
	public void deleteServico(Long id) {
		servicoRepository.deleteById(id);
	}
}
