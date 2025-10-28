package com.casa_camarim.service;

import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Agenda;
import com.casa_camarim.repositories.AgendaRepository;

@Service
public class AgendaService {
	
    private final AgendaRepository repo;
    public AgendaService(AgendaRepository repo) { this.repo = repo; }
    public Agenda save(Agenda a) { return repo.save(a); }
    public Iterable<Agenda> findAll() { return repo.findAll(); }
}

