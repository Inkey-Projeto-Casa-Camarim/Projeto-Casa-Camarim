package com.casa_camarim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casa_camarim.entities.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    // Busca todos os agendamentos por telefone do cliente
    List<Agenda> findByTelefone(String telefone);
}
