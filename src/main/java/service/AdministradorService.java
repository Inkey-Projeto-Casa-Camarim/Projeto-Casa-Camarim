package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Administrador;
import repositories.AdministradorRepository;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository administradorRepository;
	
	public Administrador saveAdministrador(Administrador administrador) {
		return administradorRepository.save(administrador);
	}

	public List<Administrador> getAllAdministrador() {
		return administradorRepository.findAll();
	}

	public Administrador getAdministradorById(Long id) {
		return administradorRepository.findById(id).orElse(null);
	}

	public void deleteAdministrador(Long id) {
		administradorRepository.deleteById(id);
	}
}