package com.casa_camarim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casa_camarim.entities.TipoUsuario;
import com.casa_camarim.service.TipoUsuarioService;

@RestController
@RequestMapping("/tipo_usuario")
public class TipoUsuarioController {
	
	@Autowired
	private TipoUsuarioService tipoUsuarioService;

	//Endpoint para salvar o TipoUsuario
	@PostMapping
	public TipoUsuario saveTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
		return tipoUsuarioService.saveTipoUsuario(tipoUsuario);
	}

	//Endpoint para buscar o TipoUsuario
	@GetMapping
	public List<TipoUsuario> getAllTipoUsuario() {
		return tipoUsuarioService.getAllTipoUsuario();
	}

	// Endpoint para buscar usuário por ID no TipoUsuario
	@GetMapping("/{id}")
	public TipoUsuario getTipoUsuarioById(@PathVariable Long id) {
		return tipoUsuarioService.getTipoUsuarioById(id);
	}
	
	// Endpoint para editar os TipoUsuario
	@PutMapping
	public TipoUsuario editTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
		return tipoUsuarioService.saveTipoUsuario(tipoUsuario);
	}

    // Endpoint para deletar um usuário no TipoUsuario
	@DeleteMapping("/{id}")
	public void deleteTipoUsuario(@PathVariable Long id) {
		tipoUsuarioService.deleteTipoUsuario(id);
	}
	
	// Autentica um usuário pela Senha enviado via POST e retorna o objeto se existir; senão, retorna null.
	@PostMapping("/login")
	public TipoUsuario login(@RequestBody TipoUsuario loginRequest) {
		TipoUsuario tipoUsuario = tipoUsuarioService.autenticarSenha(loginRequest.getSenha());
		if(tipoUsuario != null) {
			return tipoUsuario;
		}
		return null;	
	}

}
