package com.casa_camarim.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casa_camarim.entities.TipoUsuario;

@Repository
public interface TipoUsuarioRepository extends CrudRepository<TipoUsuario, Long> {

}