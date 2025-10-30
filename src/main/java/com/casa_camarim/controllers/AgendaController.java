package com.casa_camarim.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.casa_camarim.entities.Agenda;
import com.casa_camarim.service.AgendaService;

@RestController
@RequestMapping("/api/agenda") // corrigido para coincidir com front-end
@CrossOrigin(origins = "*") // permite requisições do front
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    // Criar um novo agendamento
    @PostMapping
    public Agenda saveAgenda(@RequestBody Agenda agenda) {
        return agendaService.saveAgenda(agenda);
    }

    // Listar todos os agendamentos (para admin)
    @GetMapping
    public List<Agenda> getAllAgenda() {
        return agendaService.getAllAgenda();
    }

    // Buscar agendamento por ID
    @GetMapping("/{id}")
    public Agenda getAgendaById(@PathVariable Long id) {
        return agendaService.getAgendaById(id);
    }

    // Editar um agendamento
    @PutMapping
    public Agenda editAgenda(@RequestBody Agenda agenda) {
        return agendaService.saveAgenda(agenda);
    }

    // Deletar um agendamento por ID
    @DeleteMapping("/{id}")
    public void deleteAgenda(@PathVariable Long id) {
        agendaService.deleteAgenda(id);
    }

    // Buscar todos os agendamentos de um cliente pelo telefone
    @GetMapping("/telefone/{telefone}")
    public List<Agenda> getAgendaByTelefone(@PathVariable String telefone) {
        return agendaService.getAgendaByTelefone(telefone);
    }

    // Listar datas disponíveis para um serviço
    @GetMapping("/datas")
    public List<String> getDatasDisponiveis(@RequestParam Long serviceId) {
        // Exemplo simples: retornar os próximos 7 dias como strings
        return LocalDate.now().datesUntil(LocalDate.now().plusDays(7))
                .map(LocalDate::toString)
                .collect(Collectors.toList());
    }

    // Listar horários disponíveis para um serviço em determinado dia
    @GetMapping("/horarios")
    public List<String> getHorariosDisponiveis(@RequestParam Long serviceId, @RequestParam String dia) {
        LocalDate data = LocalDate.parse(dia); // converte string para LocalDate
        // Exemplo simples: horários fixos
        List<LocalTime> horarios = List.of(
                LocalTime.of(8, 0),
                LocalTime.of(9, 0),
                LocalTime.of(10, 0),
                LocalTime.of(11, 0),
                LocalTime.of(14, 0),
                LocalTime.of(15, 0),
                LocalTime.of(16, 0)
        );
        return horarios.stream()
                .map(LocalTime::toString)
                .collect(Collectors.toList());
    }
}
