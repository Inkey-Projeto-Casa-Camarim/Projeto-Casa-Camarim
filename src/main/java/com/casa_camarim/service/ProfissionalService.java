package com.casa_camarim.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casa_camarim.entities.Profissional;

@Service
public interface ProfissionalService {
	
	 List<Profissional> getAllProfissional();
	 
	    Optional<Profissional> getProfissionalById(Long id);
	    
	    Profissional saveProfissional(Profissional profissional);
	    
	    void deleteProfissional(Long id);
	    
	    Profissional findByCpf(String cpf);
			
}
