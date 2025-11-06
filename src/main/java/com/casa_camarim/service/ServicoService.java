package com.casa_camarim.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Servico;

//Indica ao Spring que esta classe é um serviço e deve ser gerenciada pelo container
@Service 
public interface ServicoService {

	List<Servico> getAllServicos();
	
    Optional<Servico> getServicoById(Long id);
    
    Servico saveServico(Servico servico);
    
    Servico updateServico(Long id, Servico servico);
    
    void deleteServico(Long id);
}
