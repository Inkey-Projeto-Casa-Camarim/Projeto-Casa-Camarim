package com.casa_camarim.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casa_camarim.entities.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {
    // Busca um TipoUsuario pelo nome e senha
    Optional<TipoUsuario> findByNomeAndSenha(String nome, String senha);
}