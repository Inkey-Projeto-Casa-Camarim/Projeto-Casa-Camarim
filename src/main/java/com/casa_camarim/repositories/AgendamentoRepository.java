package com.casa_camarim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.casa_camarim.entities.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

	List<Agendamento> findByTelefone(String telefone);
    
    @Query("SELECT a FROM Agenda a WHERE a.cliente.id = :clienteId")
    List<Agendamento> findByClienteId(@Param("clienteId") Long clienteId);
    
    @Query("SELECT a FROM Agenda a WHERE a.usuario.id = :clienteId OR a.telefone = :telefone")
    List<Agendamento> findByClienteIdOrTelefone(@Param("clienteId") Long clienteId, @Param("telefone") String telefone);
    
    List<Agendamento> findByStatus(String status);
}
