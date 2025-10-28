package com.casa_camarim.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casa_camarim.entities.Servico;

//Interface responsável por acessar o banco de dados da entidade Servico
@Repository
public interface ServicoRepository extends CrudRepository<Servico, Long> {
 // Métodos básicos de acesso ao banco já fornecidos pelo JpaRepository
}