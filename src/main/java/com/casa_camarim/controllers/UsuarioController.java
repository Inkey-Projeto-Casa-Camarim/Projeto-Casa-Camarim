package com.casa_camarim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casa_camarim.entities.Usuario;
import com.casa_camarim.service.UsuarioService;

//Controller REST para gerenciar usuários.
//Expõe endpoints para criar, listar, buscar por ID e deletar usuários.
@RestController
@RequestMapping("/tb_usuario")
public class UsuarioController {

	// Injeta automaticamente o service do usuário
	@Autowired
	private UsuarioService usuarioService;

	// Endpoint para salvar um usuário
	@PostMapping("/register")
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
		Usuario novoUsuario = usuarioService.saveUsuario(usuario);
		return ResponseEntity.ok(novoUsuario);
	}

	// Endpoint para buscar um usuário
	@GetMapping
	public List<Usuario> getAllUsuario() {
		return usuarioService.getAllUsuario();
	}

	// Endpoint para buscar usuário por ID
	@GetMapping("/{id}")
	public Usuario getUsuarioById(@PathVariable Long id) {
		return usuarioService.getUsuarioById(id);
	}
	
	// Endpoint para editar os usuários
	@PutMapping
	public Usuario editusuario(@RequestBody Usuario usuario) {
		return usuarioService.saveUsuario(usuario);
	}
	
	// Endpoint para deletar um usuário
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable Long id) {
		usuarioService.deleteUsuario(id);
	}

	// Endpoint para logar o usuário
    	@GetMapping("/login")
        public Usuario login(@RequestBody Usuario loginRequest) {
    		Usuario usuario = usuarioService.getUsuarioByTelefone(loginRequest.getTelefone());
    			if(usuario != null) {
    				return usuario;
    			}
    			return null;
    	}
    
}
