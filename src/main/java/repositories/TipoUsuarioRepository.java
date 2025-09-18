package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long>{

}
