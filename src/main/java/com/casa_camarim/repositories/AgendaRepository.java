package com.casa_camarim.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casa_camarim.entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    // Retorna todas as agendas ordenadas pela data e hora crescente
    List<Agenda> findAllByOrderByDataHoraAsc();

    // Retorna agendas de um serviço específico dentro de um intervalo de datas
    List<Agenda> findByServicoIdAndDataHoraBetween(Long servicoId, LocalDateTime start, LocalDateTime end);
}
