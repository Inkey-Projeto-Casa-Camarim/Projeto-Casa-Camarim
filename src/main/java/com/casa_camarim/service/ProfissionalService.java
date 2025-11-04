package com.casa_camarim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Profissional;
import com.casa_camarim.repositories.ProfissionalRepository;

@Service
public class ProfissionalService {

			// Injeta automaticamente o repositório do Serviço
			@Autowired
			private ProfissionalRepository profissionalRepository;
			
			// Salva ou atualiza um serviço no banco de dados.
			public Profissional saveProfissional(Profissional profissional) {
				return profissionalRepository.save(profissional);
			}

			// Retorna todos os serviços cadastrados.
			public List<Profissional> getAllProfissional() {
				return profissionalRepository.findAll();
			}

			// Busca um serviço pelo seu ID.
			public Profissional getProfissionalById(Long id) {
				return profissionalRepository.findById(id).orElse(null);
			}

			// Exclui um serviço pelo ID.
			public void deleteProfissional(Long id) {
				profissionalRepository.deleteById(id);
			}
			
			// Busca todos os agendamentos de um cliente
		    public List<Profissional> getProfissionalByCpf(String cpf) {
		        return profissionalRepository.findByCpf(cpf);
		    }
}
