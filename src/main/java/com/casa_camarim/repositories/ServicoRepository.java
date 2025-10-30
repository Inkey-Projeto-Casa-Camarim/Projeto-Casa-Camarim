package com.casa_camarim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.casa_camarim.entities.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
