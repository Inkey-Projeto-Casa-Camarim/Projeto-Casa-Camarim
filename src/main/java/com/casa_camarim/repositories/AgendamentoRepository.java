package com.casa_camarim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casa_camarim.entities.Agendamento;
import com.casa_camarim.entities.Cliente;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // Busca todos os agendamentos pelo id do cliente
    List<Agendamento> findByCliente(Cliente cliente);
}
