package com.casa_camarim.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casa_camarim.entities.Usuario;

@Service
public class UsuarioService {
	
    private final UsuarioRepository repo;
    public UsuarioService(UsuarioRepository repo) { this.repo = repo; }

    @Transactional
    public Usuario findOrCreate(String nome, String telefone) {
        Optional<Usuario> op = repo.findByTelefone(telefone);
        if (op.isPresent()) {
            Usuario u = op.get();
            // atualiza nome se diferente
            if (!u.getNome().equals(nome)) {
                u.setNome(nome);
                repo.save(u);
            }
            return u;
        } else {
            Usuario novo = new Usuario(nome, telefone);
            return repo.save(novo);
        }
    }
}
