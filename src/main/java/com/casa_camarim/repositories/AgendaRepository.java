package com.casa_camarim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.casa_camarim.entities.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    // Retorna apenas os horários existentes no banco
    @Query("SELECT DISTINCT a.hora FROM Agenda a ORDER BY a.hora ASC")
    List<String> findAllHoras();
}
