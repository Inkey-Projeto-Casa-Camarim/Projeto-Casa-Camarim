package com.casa_camarim.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Servico;

@Service
public class ServicoService {
	
    private final ServicoRepository repo;
    public ServicoService(ServicoRepository repo) { this.repo = repo; }

    public List<Servico> listarTodos() { return repo.findAll(); }
    public Optional<Servico> findById(Long id) { return repo.findById(id); }
    public Servico salvar(Servico s) { return repo.save(s); }
}
