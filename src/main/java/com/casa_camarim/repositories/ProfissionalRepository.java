package com.casa_camarim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.casa_camarim.entities.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long>{

    @Query("SELECT t FROM Profissional t WHERE t.cpf = :cpf")
    Profissional findByCpf(@Param("nomeTipo") String cpf);
}
