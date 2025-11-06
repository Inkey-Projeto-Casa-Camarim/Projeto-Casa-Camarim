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

import com.casa_camarim.entities.Profissional;
import com.casa_camarim.service.ProfissionalService;

@RestController
@RequestMapping("/api/profissional") // Define o endpoint principal do controller
@CrossOrigin(origins = "*") // Permite requisições vindas do front-end
public class ProfissionalController {

    // Injeta automaticamente o service do Profissional
    @Autowired
    private ProfissionalService profissionalService;

    // Cria um novo profissional no banco de dados
    @PostMapping
    public Profissional saveProfissional(@RequestBody Profissional profissional) {
        return profissionalService.saveProfissional(profissional);
    }

    // Retorna a lista de todos os profissionais cadastrados
    @GetMapping
    public List<Profissional> getAllProfissional() {
        return profissionalService.getAllProfissional();
    }

    // Busca um profissional específico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Profissional> getProfissionalById(@PathVariable Long id) {
        Optional<Profissional> profissional = profissionalService.getProfissionalById(id);
        return profissional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Edita as informações de um profissional existente
    @PutMapping("/{id}")
    public ResponseEntity<Profissional> editProfissional(@PathVariable Long id, @RequestBody Profissional profissional) {
        Optional<Profissional> profissionalExistente = profissionalService.getProfissionalById(id);
        
        if (profissionalExistente.isPresent()) {
            profissional.setId_profissional(id);
            Profissional profissionalAtualizado = profissionalService.saveProfissional(profissional);
            return ResponseEntity.ok(profissionalAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deleta um profissional pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfissional(@PathVariable Long id) {
        if (profissionalService.getProfissionalById(id).isPresent()) {
            profissionalService.deleteProfissional(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
