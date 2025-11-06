package com.casa_camarim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.casa_camarim.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    @Query("SELECT t FROM Cliente t WHERE t.telefone = :telefone")
    Cliente findByTelefone(@Param("telefone") String telefone);
}
