package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.TipoUsuario;
import service.TipoUsuarioService;

@RestController
@RequestMapping("/tipo_usuario")
public class TipoUsuarioController {
	
	@Autowired
	private TipoUsuarioService tipoUsuarioService;

	//Endpoint para salvar 
	@PostMapping
	public TipoUsuario saveTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
		return tipoUsuarioService.saveTipoUsuario(tipoUsuario);
	}

	//Endpoint para buscar 
	@GetMapping
	public List<TipoUsuario> getAllTipoUsuario() {
		return tipoUsuarioService.getAllTipoUsuario();
	}

	//Endpoint para buscar usuário por ID
	@GetMapping("/{id}")
	public TipoUsuario getTipoUsuarioById(@PathVariable Long id) {
		return tipoUsuarioService.getTipoUsuarioById(id);
	}
	
	@GetMapping("/cpf/{cpf}")
    public ResponseEntity<Object> buscarTipoUsuarioPorCpf(@PathVariable String cpf) {
        TipoUsuario tipoUsuario = tipoUsuarioService.buscarTipoUsuarioPorCpf(cpf);

        if (tipoUsuario != null) {
            return ResponseEntity.ok(tipoUsuario);
        } else {
            return ResponseEntity.status(404).body("Administrador com CPF " + cpf + "não foi encontrado");
        }
    }

    //Endpoint para deletar um usuário
	@DeleteMapping("/{id}")
	public void deleteTipoUsuario(@PathVariable Long id) {
		tipoUsuarioService.deleteTipoUsuario(id);
	}

}
