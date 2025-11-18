package com.casa_camarim.controllers;

import com.casa_camarim.entities.Usuario;
import com.casa_camarim.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/agendar-auth")
@CrossOrigin(origins = "*")
public class AgendarAuthController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/verificar")
    public ResponseEntity<?> verificarUsuario(@RequestBody Map<String, String> request) {
        try {
            String telefone = request.get("telefone");
            Optional<Usuario> usuario = usuarioService.buscarPorTelefone(telefone);
            
            Map<String, Object> response = new HashMap<>();
            response.put("existe", usuario.isPresent());
            if (usuario.isPresent()) {
                response.put("usuarioId", usuario.get().getId());
                response.put("nome", usuario.get().getNome());
            }
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}