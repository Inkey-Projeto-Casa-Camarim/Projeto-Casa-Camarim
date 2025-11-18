package com.casa_camarim.repositories;

import com.casa_camarim.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByTelefone(String telefone);
    Optional<Usuario> findByTelefoneAndSenha(String telefone, String senha);
    boolean existsByTelefone(String telefone);
}