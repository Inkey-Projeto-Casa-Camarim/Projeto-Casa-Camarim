package com.casa_camarim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    // Criar um novo agendamento
    @PostMapping
    public Agendamento saveAgendamento(@RequestBody Agendamento agendamento) {
        return agendamentoService.saveAgendamento(agendamento);
    }

    // Listar todos os agendamentos (para admin)
    @GetMapping
    public List<Agendamento> getAllAgendamento() {
        return agendamentoService.getAllAgendamento();
    }

    // Buscar agendamento por ID
    @GetMapping("/{id}")
    public Agendamento getAgendamentoById(@PathVariable Long id) {
        return agendamentoService.getAgendamentoById(id);
    }

    // Editar um agendamento
    @PutMapping
    public Agendamento editAgendamento(@RequestBody Agendamento agendamento) {
        return agendamentoService.saveAgendamento(agendamento);
    }

    // Deletar um agendamento por ID
    @DeleteMapping("/{id}")
    public void deleteAgendamento(@PathVariable Long id) {
        agendamentoService.deleteAgendamento(id);
    }

    // Buscar todos os agendamentos de um cliente pelo id
    @GetMapping("/telefone/{telefone}")
    public List<Agendamento> getFindByTelefone(@PathVariable String telefone) {
        return agendamentoService.getFindByTelefone(telefone);
    }
    
 // Buscar todos os agendamentos de uma data específica
    @GetMapping("/data/{data}")
    public List<Agendamento> getAgendamentosPorData(@PathVariable String data) {
        return agendamentoService.getAgendamentosPorData(data);
    }

}