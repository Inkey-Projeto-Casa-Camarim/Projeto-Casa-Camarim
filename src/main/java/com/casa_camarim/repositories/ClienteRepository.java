package com.casa_camarim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casa_camarim.entities.Cliente;

// Classe responsável por acessar e manipular os dados da entidade Cliente no banco de dados
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findByTelefone(String telefone);
}