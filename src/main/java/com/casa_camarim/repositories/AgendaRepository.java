package com.casa_camarim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casa_camarim.entities.Agenda;

// Repositório responsável pelo acesso e manipulação dos dados da entidade

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long>{

}
