package com.casa_camarim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casa_camarim.entities.Servico;

// Repositório responsável pelo acesso e manipulação dos dados da entidade
@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
