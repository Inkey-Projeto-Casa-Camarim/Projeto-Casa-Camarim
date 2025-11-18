package com.casa_camarim.repositories;

import com.casa_camarim.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByUsuarioIdOrderByDataDescHorarioDesc(Long usuarioId);
    List<Agendamento> findAllByOrderByDataAscHorarioAsc();
    List<Agendamento> findByDataAndHorarioAndServicoId(LocalDate data, LocalTime horario, Long servicoId);
    
    @Query("SELECT a.horario FROM Agendamento a WHERE a.servico.id = :servicoId AND a.data = :data AND a.status = 'AGENDADO'")
    List<LocalTime> findHorariosOcupados(@Param("servicoId") Long servicoId, @Param("data") LocalDate data);
}