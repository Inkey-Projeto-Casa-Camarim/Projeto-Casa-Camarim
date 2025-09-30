package com.casa_camarim.controllers;

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

import com.casa_camarim.entities.Usuario;
import com.casa_camarim.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	//Endpoint para salvar 
	@PostMapping
	public Usuario saveUsuario(@RequestBody Usuario usuario) {
		return usuarioService.saveUsuario(usuario);
	}

	//Endpoint para buscar 
	@GetMapping
	public List<Usuario> getAllUsuario() {
		return usuarioService.getAllUsuario();
	}

	//Endpoint para buscar usuário por ID
	@GetMapping("/{id}")
	public Usuario getUsuarioById(@PathVariable Long id) {
		return usuarioService.getUsuarioById(id);
	}

    	@GetMapping("/cpf/{cpf}")
        public ResponseEntity<Object> buscarUsuarioPorTelefone(@PathVariable String telefone) {
            Usuario usuario = usuarioService.buscarUsuarioPorTelefone(telefone);

            if (usuario != null) {
                return ResponseEntity.ok(usuario);
            } else {
                return ResponseEntity.status(404).body("Cliente com telefone " + telefone + "não foi encontrado");
            }
        }

    //Endpoint para deletar um usuário
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable Long id) {
		usuarioService.deleteUsuario(id);
	}
    
}
