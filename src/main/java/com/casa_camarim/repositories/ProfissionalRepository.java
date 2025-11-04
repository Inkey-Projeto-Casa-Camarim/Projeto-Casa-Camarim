package com.casa_camarim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casa_camarim.entities.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long>{

	List<Profissional> findByCpf(String cpf);
}
