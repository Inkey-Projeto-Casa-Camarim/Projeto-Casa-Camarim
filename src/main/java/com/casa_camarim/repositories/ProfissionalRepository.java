package com.casa_camarim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.casa_camarim.entities.Profissional;

// Classe responsável por acessar e manipular os dados da entidade Profissional no banco de dados
@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    // Consulta personalizada (JPQL) que busca um profissional pelo CPF informado
    @Query("SELECT t FROM Profissional t WHERE t.cpf = :cpf")
    Profissional findByCpf(@Param("cpf") String cpf);
}
