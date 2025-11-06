package com.casa_camarim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.casa_camarim.entities.Cliente;

// Classe responsável por acessar e manipular os dados da entidade Cliente no banco de dados
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Consulta personalizada (JPQL) que busca um cliente pelo número de telefone informado
    @Query("SELECT t FROM Cliente t WHERE t.telefone = :telefone")
    Cliente findByTelefone(@Param("telefone") String telefone);
}