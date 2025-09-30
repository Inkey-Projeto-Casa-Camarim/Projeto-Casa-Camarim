package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entities.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}
