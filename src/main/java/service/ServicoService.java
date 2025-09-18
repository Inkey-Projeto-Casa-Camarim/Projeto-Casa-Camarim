package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Servico;
import repositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
private ServicoRepository servicoRepository;
	
	public Servico saveServico(Servico servico) {
		return servicoRepository.save(servico);
	}

	public List<Servico> getAllServico() {
		return servicoRepository.findAll();
	}

	public Servico getServicoById(Long id) {
		return servicoRepository.findById(id).orElse(null);
	}

	public void deleteServico(Long id) {
		servicoRepository.deleteById(id);
	}
}
