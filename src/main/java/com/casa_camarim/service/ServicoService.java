package com.casa_camarim.service;

import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Servico;
import com.casa_camarim.repositories.ServicoRepository;

@Service
public class ServicoService {
	
	  private final ServicoRepository repo;
	    public ServicoService(ServicoRepository repo) { this.repo = repo; }
	    public Iterable<Servico> findAll() { return repo.findAll(); }
	    public Servico save(Servico s) { return repo.save(s); }
	}
