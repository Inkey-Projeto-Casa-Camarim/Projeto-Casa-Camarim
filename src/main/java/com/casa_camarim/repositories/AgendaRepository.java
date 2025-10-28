package com.casa_camarim.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casa_camarim.entities.Agenda;

@Repository
public interface AgendaRepository extends CrudRepository<Agenda, Long> {
   
}
