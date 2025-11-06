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

import com.casa_camarim.entities.Servico;
import com.casa_camarim.service.ServicoService;

// Controller responsável por gerenciar os endpoints relacionados aos serviços
@RestController
@RequestMapping("/api/servico") // Define o caminho base dos endpoints
@CrossOrigin(origins = "*") // Permite chamadas do front-end
public class ServicoController {
	
    // Injeta automaticamente o serviço responsável pela lógica de negócio dos serviços
    @Autowired
    private ServicoService servicoService;

    // Cria um novo serviço e salva no banco de dados
    @PostMapping
    public Servico saveServico(@RequestBody Servico servico) {
        return servicoService.saveServico(servico);
    }

    // Retorna a lista de todos os serviços cadastrados
    @GetMapping
    public List<Servico> getAllServicos() {
        return servicoService.getAllServicos();
    }

    // Busca um serviço específico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Servico> getServicoById(@PathVariable Long id) {
        Optional<Servico> servico = servicoService.getServicoById(id);
        return servico.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Atualiza os dados de um serviço existente
    @PutMapping("/{id}")
    public ResponseEntity<Servico> editServico(@PathVariable Long id, @RequestBody Servico servico) {
        Servico servicoAtualizado = servicoService.updateServico(id, servico);
        if (servicoAtualizado != null) {
            return ResponseEntity.ok(servicoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deleta um serviço do banco de dados pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServico(@PathVariable Long id) {
        if (servicoService.getServicoById(id).isPresent()) {
            servicoService.deleteServico(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
