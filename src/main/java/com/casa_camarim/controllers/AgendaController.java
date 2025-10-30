package com.casa_camarim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.casa_camarim.entities.Agenda;
import com.casa_camarim.service.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    // Criar um novo agendamento (o corpo JSON deve conter nomeCliente, telefone, data, hora)
    @PostMapping
    public Agenda saveAgenda(@RequestBody Agenda agenda) {
        return agendaService.saveAgenda(agenda);
    }

    // Listar todos os agendamentos (para o admin)
    @GetMapping
    public List<Agenda> getAllAgenda() {
        return agendaService.getAllAgenda();
    }

    // Buscar agendamento por ID
    @GetMapping("/{id}")
    public Agenda getAgendaById(@PathVariable Long id) {
        return agendaService.getAgendaById(id);
    }

    // Editar um agendamento (enviar JSON completo com id_agenda existente)
    @PutMapping
    public Agenda editAgenda(@RequestBody Agenda agenda) {
        return agendaService.saveAgenda(agenda);
    }

    // Deletar um agendamento por ID (pode ser usado tanto por cliente quanto admin — validação pode ser adicionada depois)
    @DeleteMapping("/{id}")
    public void deleteAgenda(@PathVariable Long id) {
        agendaService.deleteAgenda(id);
    }

    // Buscar todos os agendamentos de um cliente pelo telefone (para o cliente consultar seus agendamentos)
    @GetMapping("/telefone/{telefone}")
    public List<Agenda> getAgendaByTelefone(@PathVariable String telefone) {
        return agendaService.getAgendaByTelefone(telefone);
    }
}
