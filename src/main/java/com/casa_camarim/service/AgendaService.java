package com.casa_camarim.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casa_camarim.entities.Agenda;
import com.casa_camarim.entities.Servico;
import com.casa_camarim.entities.Usuario;
import com.casa_camarim.repositories.AgendaRepository;

@Service
public class AgendaService {
	
    private final AgendaRepository repo;
    public AgendaService(AgendaRepository repo) { this.repo = repo; }

    public List<Agenda> listarTodos() {
        return repo.findAllByOrderByDataHoraAsc();
    }

    /**
     * Verifica conflito básico: checa se já existe agendamento para o mesmo serviço
     * no período (dataHora até dataHora + duracao).
     */
    public boolean existeConflito(Servico servico, LocalDateTime dataHora) {
        LocalDateTime start = dataHora.minusMinutes(0);
        LocalDateTime end = dataHora.plusMinutes(servico.getTempoMinutos());
        var lista = repo.findByServicoIdAndDataHoraBetween(servico.getId(), start, end);
        return !lista.isEmpty();
    }

    @Transactional
    public Agenda criar(Usuario usuario, Servico servico, LocalDateTime dataHora, String observacao) {
        Agenda a = new Agenda(usuario, servico, dataHora, observacao);
        return repo.save(a);
    }
}
