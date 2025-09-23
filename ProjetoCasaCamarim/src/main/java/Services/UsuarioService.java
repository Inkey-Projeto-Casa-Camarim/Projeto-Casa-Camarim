package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entities.Usuario;
import Repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario saveUsuario( Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> getAllUsuario(){
		return usuarioRepository.findAll();
	}
	
	public Usuario getUsuarioById (Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public void deleteUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public Usuario autenticarPessoa(String cpf) {
	    
	// Buscar no banco de dados um usuário que tenha o cpf informado
		Usuario pessoa = usuarioRepository.findByCpf(cpf);
	    if (pessoa == null) {
	        throw new RuntimeException("Cliente não encontrado!");
	    }
	    return pessoa;
	}
}
