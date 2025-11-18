package com.casa_camarim.controllers;

import com.casa_camarim.entities.Agendamento;
import com.casa_camarim.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/agendamentos")
@CrossOrigin(origins = "*")
public class AgendamentoController {
    
    @Autowired
    private AgendamentoService agendamentoService;
    
    @PostMapping
    public ResponseEntity<?> agendar(@RequestBody Map<String, Object> agendamentoRequest) {
        try {
            Long usuarioId = agendamentoRequest.get("usuarioId") != null ? 
                Long.valueOf(agendamentoRequest.get("usuarioId").toString()) : null;
            Long servicoId = Long.valueOf(agendamentoRequest.get("servicoId").toString());
            LocalDate data = LocalDate.parse(agendamentoRequest.get("data").toString());
            LocalTime horario = LocalTime.parse(agendamentoRequest.get("horario").toString());
            String telefone = agendamentoRequest.get("telefone").toString();
            
            Agendamento agendamento = agendamentoService.agendarServico(usuarioId, servicoId, data, horario, telefone);
            return ResponseEntity.ok(agendamento);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<?> cancelarAgendamento(@PathVariable Long id) {
        try {
            agendamentoService.cancelarAgendamento(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Agendamento>> listarAgendamentosUsuario(@PathVariable Long usuarioId) {
        List<Agendamento> agendamentos = agendamentoService.listarAgendamentosUsuario(usuarioId);
        return ResponseEntity.ok(agendamentos);
    }
    
    
    @GetMapping("/admin")
    public ResponseEntity<List<Agendamento>> listarTodosAgendamentos() {
        List<Agendamento> agendamentos = agendamentoService.listarTodosAgendamentos();
        return ResponseEntity.ok(agendamentos);
    }
    
    @GetMapping("/horarios-disponiveis")
    public ResponseEntity<List<LocalTime>> listarHorariosDisponiveis(
            @RequestParam Long servicoId,
            @RequestParam String data) {
        
        LocalDate dataConsulta = LocalDate.parse(data);
        List<LocalTime> horarios = agendamentoService.listarHorariosDisponiveis(servicoId, dataConsulta);
        return ResponseEntity.ok(horarios);
    }
}