package com.casa_camarim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casa_camarim.entities.TipoUsuario;
import com.casa_camarim.repositories.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {

	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;
		
		public TipoUsuario saveTipoUsuario(TipoUsuario tipoUsuario) {
			return tipoUsuarioRepository.save(tipoUsuario);
		}

		public List<TipoUsuario> getAllTipoUsuario() {
			return tipoUsuarioRepository.findAll();
		}

		public TipoUsuario getTipoUsuarioById(Long id) {
			return tipoUsuarioRepository.findById(id).orElse(null);
		}

		public TipoUsuario buscarTipoUsuarioPorCpf(String cpf) {
	        return tipoUsuarioRepository.findByCpf(cpf);
	    }
		
		public void deleteTipoUsuario(Long id) {
			tipoUsuarioRepository.deleteById(id);
		}
}
