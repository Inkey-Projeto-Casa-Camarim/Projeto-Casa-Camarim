package com.casa_camarim.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casa_camarim.entities.Agendamento;
import com.casa_camarim.entities.Cliente;
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
    @GetMapping("/id/{id}")
    public List<Agendamento> getAgendamentoByCliente(@PathVariable Cliente cliente) {
        return agendamentoService.getAgendamentoByCliente(cliente);
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
