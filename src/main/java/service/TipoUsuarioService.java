package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.TipoUsuario;
import repositories.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {

	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;
		
		public TipoUsuario saveServico(TipoUsuario tipoUsuario) {
			return tipoUsuarioRepository.save(tipoUsuario);
		}

		public List<TipoUsuario> getAllTipoUsuario() {
			return tipoUsuarioRepository.findAll();
		}

		public TipoUsuario getTipoUsuarioById(Long id) {
			return tipoUsuarioRepository.findById(id).orElse(null);
		}

		public void deleteTipoUsuario(Long id) {
			tipoUsuarioRepository.deleteById(id);
		}
}
