package com.casa_camarim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casa_camarim.entities.TipoUsuario;
import com.casa_camarim.repositories.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {

	@Autowired // Pede pro Spring para fornecer automaticamente uma instância de TipoUsuarioRepository neste local
	private TipoUsuarioRepository tipoUsuarioRepository;
		
		// Recebe um objeto (TipoUsuario) e o salva no banco
		public TipoUsuario saveTipoUsuario(TipoUsuario tipoUsuario) {
			return tipoUsuarioRepository.save(tipoUsuario);
		}

		// Retorna uma lista com todas as agendas do banco de dados
		public List<TipoUsuario> getAllTipoUsuario() {
			return tipoUsuarioRepository.findAll();
		}

		// Busca uma Agenda pelo ID
		public TipoUsuario getTipoUsuarioById(Long id) {
			return tipoUsuarioRepository.findById(id).
					orElseThrow(() -> new RuntimeException("Tipo Cliente não encontrado"));
		}
		
		// Deleta a agenda com o ID fornecido
		public void deleteTipoUsuario(Long id) {
			tipoUsuarioRepository.deleteById(id);
		}
		
		// Busca um adm ou usuário pelo CPF e retorna o objeto se existir... Caso contrário, retorna null.
		public TipoUsuario autenticarCpf(String cpf) {
	        TipoUsuario tipoUsuario = tipoUsuarioRepository.findByCpf(cpf);
	        if(tipoUsuario != null) {
	        		return tipoUsuario;
	        }
	        return null;
	    }
}
