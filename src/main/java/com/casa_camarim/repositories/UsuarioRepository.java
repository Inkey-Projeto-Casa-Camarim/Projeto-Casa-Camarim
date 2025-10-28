package com.casa_camarim.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Busca um usuário pelo telefone
    Optional<Usuario> findByTelefone(String telefone);
}