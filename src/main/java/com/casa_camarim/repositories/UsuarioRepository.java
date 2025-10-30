package com.casa_camarim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casa_camarim.entities.Usuario;

// Repositório responsável pelo acesso e manipulação dos dados da entidade
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	// Achar o usuário pelo telefone
	Usuario findByTelefone(String telefone);
}
