package com.casa_camarim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.casa_camarim.entities.TipoUsuario;
import com.casa_camarim.service.TipoUsuarioService;

@RestController
@RequestMapping("/tb_tipoUsuario")
public class TipoUsuarioController {
	
	@Autowired
	private TipoUsuarioService tipoUsuarioService;

	// Endpoint para salvar o TipoUsuario
	@PostMapping
	public TipoUsuario saveTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
		return tipoUsuarioService.saveTipoUsuario(tipoUsuario);
	}

	// Endpoint para buscar todos os TipoUsuario
	@GetMapping
	public List<TipoUsuario> getAllTipoUsuario() {
		return tipoUsuarioService.getAllTipoUsuario();
	}

	// Endpoint para buscar um TipoUsuario pelo ID
	@GetMapping("/{id}")
	public TipoUsuario getTipoUsuarioById(@PathVariable Long id) {
		return tipoUsuarioService.getTipoUsuarioById(id);
	}
	
	// Endpoint para editar um TipoUsuario existente
	@PutMapping
	public TipoUsuario editTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
		return tipoUsuarioService.saveTipoUsuario(tipoUsuario);
	}

    // Endpoint para deletar um TipoUsuario pelo ID
	@DeleteMapping("/{id}")
	public void deleteTipoUsuario(@PathVariable Long id) {
		tipoUsuarioService.deleteTipoUsuario(id);
	}
	
	// Endpoint para autenticar um TipoUsuario pelo CPF
	@PostMapping("/login")
	public TipoUsuario login(@RequestBody TipoUsuario loginRequest) {
		TipoUsuario tipoUsuario = tipoUsuarioService.autenticarCpf(loginRequest.getCpf());
		if (tipoUsuario != null) {
			return tipoUsuario;
		}
		return null;	
	}
}
