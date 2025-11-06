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

// Controlador responsável por gerenciar as requisições HTTP relacionadas aos agendamentos no sistema.
@RestController
@RequestMapping("/api/agenda") // Define o caminho base para acessar o controller
@CrossOrigin(origins = "*") // Permite que o front-end acesse esta API (CORS liberado)
public class AgendamentoController {

    // Injeta o serviço de Agendamento para acessar as regras de negócio
    @Autowired
    private AgendamentoService agendamentoService;

    // Cria um novo agendamento
    @PostMapping
    public ResponseEntity<Agendamento> criarAgendamento(@RequestBody Agendamento agendamento) {
        try {
            Agendamento agendamentoSalvo = agendamentoService.saveAgendamento(agendamento);
            return ResponseEntity.ok(agendamentoSalvo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // Retorna erro se algo der errado
        }
    }

    // Cria um agendamento vinculado a um cliente específico
    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<Agendamento> criarAgendamentoComUsuario(@RequestBody Agendamento agendamento, @PathVariable Long clienteId) {
        try {
            Agendamento agendamentoSalvo = agendamentoService.criarAgendamentoComCliente(agendamento, clienteId);
            return ResponseEntity.ok(agendamentoSalvo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Retorna todos os agendamentos cadastrados
    @GetMapping
    public List<Agendamento> getAllAgendamentos() {
        return agendamentoService.getAllAgendamentos();
    }

    // Busca um agendamento pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> getAgendamentoById(@PathVariable Long id) {
        Optional<Agendamento> agendamento = agendamentoService.getAgendamentoById(id);
        return agendamento.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Atualiza um agendamento existente
    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> editarAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamento) {
        Agendamento agendamentoAtualizado = agendamentoService.updateAgendamento(id, agendamento);
        if (agendamentoAtualizado != null) {
            return ResponseEntity.ok(agendamentoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Exclui um agendamento pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgendamento(@PathVariable Long id) {
        if (agendamentoService.getAgendamentoById(id).isPresent()) {
            agendamentoService.deleteAgendamento(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Busca agendamentos pelo telefone do cliente
    @GetMapping("/telefone/{telefone}")
    public List<Agendamento> getAgendamentoByTelefone(@PathVariable String telefone) {
        return agendamentoService.getAgendamentosByTelefone(telefone);
    }

    // Busca agendamentos vinculados a um cliente específico
    @GetMapping("/usuario/{usuarioId}")
    public List<Agendamento> getAgendamentoByUsuario(@PathVariable Long clienteId) {
        return agendamentoService.getAgendamentosByClienteId(clienteId);
    }
}
