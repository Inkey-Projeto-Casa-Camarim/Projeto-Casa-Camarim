package com.casa_camarim.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casa_camarim.entities.Agendamento;
import com.casa_camarim.service.AgendamentoService;

@RestController
@RequestMapping("/api/agenda") // corrigido para coincidir com front-end
@CrossOrigin(origins = "*") // permite requisições do front
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> criarAgendamento(@RequestBody Agendamento agendamento) {
        try {
        	Agendamento agendamentoSalvo = agendamentoService.saveAgendamento(agendamento);
            return ResponseEntity.ok(agendamentoSalvo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<Agendamento> criarAgendamentoComUsuario(@RequestBody Agendamento agendamento, @PathVariable Long clienteId) {
        try {
        	Agendamento agendamentoSalvo = agendamentoService.criarAgendamentoComCliente(agendamento, clienteId);
            return ResponseEntity.ok(agendamentoSalvo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public List<Agendamento> getAllAgendamentos() {
        return agendamentoService.getAllAgendamentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> getAgendamentoById(@PathVariable Long id) {
        Optional<Agendamento> agendamento = agendamentoService.getAgendamentoById(id);
        return agendamento.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> editarAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamento) {
    	Agendamento agendamentoAtualizada = agendamentoService.updateAgendamento(id, agendamento);
        if (agendamentoAtualizada != null) {
            return ResponseEntity.ok(agendamentoAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgendamento(@PathVariable Long id) {
        if (agendamentoService.getAgendamentoById(id).isPresent()) {
        	agendamentoService.deleteAgendamento(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/telefone/{telefone}")
    public List<Agendamento> getAgendamentoByTelefone(@PathVariable String telefone) {
        return agendamentoService.getAgendamentosByTelefone(telefone);
    }
    
    @GetMapping("/usuario/{usuarioId}")
    public List<Agendamento> getAgendamentoByUsuario(@PathVariable Long clienteId) {
        return agendamentoService.getAgendamentosByClienteId(clienteId);
    }
}