package com.casa_camarim.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.casa_camarim.entities.Servico;
import com.casa_camarim.service.ServicoService;

@Controller
public class PublicController {
	
    private final ServicoService servicoService;
    
    public PublicController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    // Página inicial com lista de serviços (se usar Thymeleaf)
    @GetMapping("/")
    public String index(Model model) {
        List<Servico> servicos = servicoService.listarTodos();
        model.addAttribute("servicos", servicos);
        return "index"; // template src/main/resources/templates/index.html (opcional)
    }
}
