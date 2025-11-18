package com.casa_camarim.service;

import com.casa_camarim.entities.Agendamento;
import com.casa_camarim.entities.Servico;
import com.casa_camarim.entities.Usuario;
import com.casa_camarim.repositories.AgendamentoRepository;
import com.casa_camarim.repositories.ServicoRepository;
import com.casa_camarim.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgendamentoService {
    
    @Autowired
    private AgendamentoRepository agendamentoRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private ServicoRepository servicoRepository;
    
    public Agendamento agendarServico(Long usuarioId, Long servicoId, LocalDate data, LocalTime horario, String telefone) {
        // Verificar se o horário está dentro do período permitido (9h-18h)
        if (horario.isBefore(LocalTime.of(9, 0))) {
            throw new RuntimeException("Horário não permitido. O salão abre às 9:00");
        }
        if (horario.isAfter(LocalTime.of(18, 0))) {
            throw new RuntimeException("Horário não permitido. O salão fecha às 18:00");
        }
        
        // Verificar se o horário está disponível
        List<LocalTime> horariosOcupados = agendamentoRepository.findHorariosOcupados(servicoId, data);
        if (horariosOcupados.contains(horario)) {
            throw new RuntimeException("Horário já ocupado");
        }
        
        Servico servico = servicoRepository.findById(servicoId)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        
        Agendamento agendamento = new Agendamento();
        agendamento.setData(data);
        agendamento.setHorario(horario);
        agendamento.setServico(servico);
        agendamento.setTelefoneUsuario(telefone);
        agendamento.setStatus("AGENDADO");
        
        // Se o usuário estiver logado, associar ao usuário
        if (usuarioId != null) {
            Usuario usuario = usuarioRepository.findById(usuarioId)
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            agendamento.setUsuario(usuario);
        }
        
        Agendamento saved = agendamentoRepository.save(agendamento);
        System.out.println("=== AGENDAMENTO CRIADO ===");
        System.out.println("ID: " + saved.getId());
        System.out.println("Serviço: " + saved.getServico().getNome());
        System.out.println("Data: " + saved.getData());
        System.out.println("Horário: " + saved.getHorario());
        System.out.println("Usuário: " + (saved.getUsuario() != null ? saved.getUsuario().getNome() : "Não logado"));
        
        return saved;
    }
    
    public void cancelarAgendamento(Long agendamentoId) {
        Agendamento agendamento = agendamentoRepository.findById(agendamentoId)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
        
        agendamento.setStatus("CANCELADO");
        agendamentoRepository.save(agendamento);
        System.out.println("Agendamento " + agendamentoId + " cancelado");
    }
    
    public List<Agendamento> listarAgendamentosUsuario(Long usuarioId) {
        List<Agendamento> agendamentos = agendamentoRepository.findByUsuarioIdOrderByDataDescHorarioDesc(usuarioId);
        System.out.println("Encontrados " + agendamentos.size() + " agendamentos para o usuário " + usuarioId);
        return agendamentos;
    }
    
    public List<Agendamento> listarTodosAgendamentos() {
        List<Agendamento> agendamentos = agendamentoRepository.findAllByOrderByDataAscHorarioAsc();
        System.out.println("Encontrados " + agendamentos.size() + " agendamentos no total");
        return agendamentos;
    }
    
    public List<LocalTime> listarHorariosDisponiveis(Long servicoId, LocalDate data) {
        // Gerar todos os horários possíveis das 9h às 18h
        List<LocalTime> todosHorarios = new ArrayList<>();
        for (int hora = 9; hora <= 18; hora++) {
            todosHorarios.add(LocalTime.of(hora, 0));
        }
        
        // Buscar horários ocupados
        List<LocalTime> horariosOcupados = agendamentoRepository.findHorariosOcupados(servicoId, data);
        
        // Filtrar horários disponíveis
        List<LocalTime> horariosDisponiveis = new ArrayList<>();
        for (LocalTime horario : todosHorarios) {
            if (!horariosOcupados.contains(horario)) {
                horariosDisponiveis.add(horario);
            }
        }
        
        return horariosDisponiveis;
    }
}