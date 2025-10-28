package com.casa_camarim.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Usuario;
import com.casa_camarim.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	 private final UsuarioRepository repo;
	    public UsuarioService(UsuarioRepository repo) { this.repo = repo; }
	    public Usuario save(Usuario u) { return repo.save(u); }
	    public Optional<Usuario> findById(Long id) { return repo.findById(id); }
	}

