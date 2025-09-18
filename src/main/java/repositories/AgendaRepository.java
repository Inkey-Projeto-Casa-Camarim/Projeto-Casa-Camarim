package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long>{

}
