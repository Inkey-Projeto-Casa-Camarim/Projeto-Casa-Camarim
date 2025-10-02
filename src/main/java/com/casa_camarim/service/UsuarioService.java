package com.casa_camarim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casa_camarim.entities.TipoUsuario;
import com.casa_camarim.entities.Usuario;
import com.casa_camarim.repositories.TipoUsuarioRepository;
import com.casa_camarim.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;
		
		public Usuario saveUsuario(Usuario usuario) {
			if(usuario.getTipoUsuario() == null) {
				TipoUsuario cliente = tipoUsuarioRepository.findById(1L)
						.orElseThrow(() -> new RuntimeException("Tipo Usuário não encontrado!"));
				usuario.setTipoUsuario(usuario);
			}
			return usuarioRepository.save(usuario);
		}

		public List<Usuario> getAllUsuario() {
			return usuarioRepository.findAll();
		}

		public Usuario getUsuarioById(Long id) {
			return usuarioRepository.findById(id).
					orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
		}
		
		public void deleteUsuario(Long id) {
			usuarioRepository.deleteById(id);
		}
		
		public Usuario getUsuarioByTelefone(String telefone) {
	        Usuario usuario = usuarioRepository.findByTelefone(telefone);
	        if(usuario != null) {
	        		return usuario;
	        }
	        return usuario;
	    }

}
