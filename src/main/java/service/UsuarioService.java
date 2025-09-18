package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Usuario;
import repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
		
		public Usuario saveUsuario(Usuario usuario) {
			return usuarioRepository.save(usuario);
		}

		public List<Usuario> getAllUsuario() {
			return usuarioRepository.findAll();
		}

		public Usuario getUsuarioById(Long id) {
			return usuarioRepository.findById(id).orElse(null);
		}

		public void deleteUsuario(Long id) {
			usuarioRepository.deleteById(id);
		}
}
