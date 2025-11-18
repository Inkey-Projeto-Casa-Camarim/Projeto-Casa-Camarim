package com.casa_camarim.service;

import com.casa_camarim.entities.Servico;
import com.casa_camarim.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicoService {
    
    @Autowired
    private ServicoRepository servicoRepository;
    
    public List<Servico> listarTodosServicos() {
        return servicoRepository.findAllByOrderByNomeAsc();
    }
}