package com.casa_camarim.controllers;

import com.casa_camarim.entities.Servico;
import com.casa_camarim.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/servicos")
@CrossOrigin(origins = "*")
public class ServicoController {
    
    @Autowired
    private ServicoService servicoService;
    
    @GetMapping
    public ResponseEntity<List<Servico>> listarServicos() {
        System.out.println("=== SOLICITAÇÃO DE SERVIÇOS RECEBIDA ===");
        List<Servico> servicos = servicoService.listarTodosServicos();
        System.out.println("Total de serviços encontrados: " + servicos.size());
        servicos.forEach(servico -> {
            System.out.println("Serviço: " + servico.getNome() + " - R$ " + servico.getPreco());
        });
        return ResponseEntity.ok(servicos);
    }
    
    // Endpoint de debug
    @GetMapping("/debug")
    public ResponseEntity<String> debug() {
        long count = servicoService.listarTodosServicos().size();
        return ResponseEntity.ok("Total de serviços no banco: " + count);
    }
}