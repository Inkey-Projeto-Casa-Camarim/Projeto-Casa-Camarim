package com.casa_camarim.controllers;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casa_camarim.dto.AgendaAdminDto;
import com.casa_camarim.entities.Agenda;
import com.casa_camarim.entities.TipoUsuario;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
    private final TipoUsuarioRepository tipoRepo;
    private final AgendaRepository agendaRepo;

    public AdminController(TipoUsuarioRepository tipoRepo, AgendaRepository agendaRepo) {
        this.tipoRepo = tipoRepo;
        this.agendaRepo = agendaRepo;
    }

    @GetMapping("/atendimentos")
    public ResponseEntity<?> listarAtendimentos(@RequestParam String nome, @RequestParam String senha) {
        Optional<TipoUsuario> tu = tipoRepo.findByNomeAndSenha(nome, senha);
        if (tu.isEmpty()) return ResponseEntity.status(401).body("Acesso negado");

        List<Agenda> lista = agendaRepo.findAllByOrderByDataHoraAsc();

        List<AgendaAdminDto> dto = lista.stream().map(a -> {
            String telefone = a.getUsuario().getTelefone(); // +55...
            String texto = "Olá " + a.getUsuario().getNome() + ". Confirmando seu horário em " + a.getDataHora().toString();
            String encoded = URLEncoder.encode(texto, StandardCharsets.UTF_8);
            String whats = "https://api.whatsapp.com/send?phone=" + telefone + "&text=" + encoded;
            return new AgendaAdminDto(
                    a.getId(),
                    a.getUsuario().getNome(),
                    telefone,
                    a.getServico().getNome(),
                    a.getDataHora().toString(),
                    whats
            );
        }).collect(Collectors.toList());

        return ResponseEntity.ok(dto);
    }
}
