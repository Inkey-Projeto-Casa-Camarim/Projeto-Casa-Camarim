package com.casa_camarim.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casa_camarim.entities.TipoUsuario;
import com.casa_camarim.repositories.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {

	 private final TipoUsuarioRepository repo;
	    public TipoUsuarioService(TipoUsuarioRepository repo) { this.repo = repo; }
	    public TipoUsuario save(TipoUsuario t) { return repo.save(t); }
	    public Optional<TipoUsuario> findById(Long id) { return repo.findById(id); }
	    public Iterable<TipoUsuario> findAll() { return repo.findAll(); }
}
