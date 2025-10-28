package com.casa_camarim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casa_camarim.entities.Servico;

//Interface responsável por acessar o banco de dados da entidade Servico
public interface ServicoRepository extends JpaRepository<Servico, Long> {
 // Métodos básicos de acesso ao banco já fornecidos pelo JpaRepository
}