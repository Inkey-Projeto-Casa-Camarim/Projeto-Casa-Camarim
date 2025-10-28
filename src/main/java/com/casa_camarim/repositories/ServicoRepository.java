package com.casa_camarim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

//Interface responsável por acessar o banco de dados da entidade Servico
public interface ServicoRepository extends JpaRepository<Servico, Long> {
 // Métodos CRUD já disponíveis pelo JpaRepository
}