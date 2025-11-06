package com.casa_camarim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.casa_camarim.entities.Agendamento;

// Classe responsável por acessar e manipular os dados da entidade Agendamento no banco de dados
@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

	// Busca todos os agendamentos filtrando pelo telefone do cliente
	List<Agendamento> findByTelefone(String telefone);
    
	// Consulta personalizada (JPQL) que busca agendamentos de um cliente específico
    @Query("SELECT a FROM Agenda a WHERE a.cliente.id = :clienteId")
    List<Agendamento> findByClienteId(@Param("clienteId") Long clienteId);
    
    // Consulta personalizada que busca agendamentos por ID do cliente ou telefone
    @Query("SELECT a FROM Agenda a WHERE a.usuario.id = :clienteId OR a.telefone = :telefone")
    List<Agendamento> findByClienteIdOrTelefone(@Param("clienteId") Long clienteId, @Param("telefone") String telefone);
    
    // Busca todos os agendamentos com base no status (ex: "AGENDADO", "CONCLUÍDO")
    List<Agendamento> findByStatus(String status);
}