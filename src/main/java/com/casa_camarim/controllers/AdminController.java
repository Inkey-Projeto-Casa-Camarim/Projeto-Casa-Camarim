package com.casa_camarim.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casa_camarim.entities.Servico;
import com.casa_camarim.entities.Usuario;
import com.casa_camarim.service.ServicoService;
import com.casa_camarim.service.UsuarioService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final ServicoService servicoService;
    private final UsuarioService usuarioService;

    public AdminController(ServicoService servicoService, UsuarioService usuarioService) {
        this.servicoService = servicoService;
        this.usuarioService = usuarioService;
    }

    // Serviços
    @PostMapping("/servicos")
    public Servico criarServico(@RequestBody Servico s) { return servicoService.save(s); }

    @DeleteMapping("/servicos/{id}")
    public void deletarServico(@PathVariable Long id) { servicoService.delete(id); }

    // Usuários
    @PostMapping("/usuarios")
    public Usuario criarUsuario(@RequestBody Usuario u) { return usuarioService.save(u); }

            String whats = "https://api.whatsapp.com/send?phone=" + telefone + "&text=" + encoded;

            return new AgendaAdminDto(
                    a.getId_agenda(),
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
