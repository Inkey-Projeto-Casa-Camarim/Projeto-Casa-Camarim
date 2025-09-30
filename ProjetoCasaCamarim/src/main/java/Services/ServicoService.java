package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entities.Servico;
import Repositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;

	public Servico saveServico(Servico servico) {
		return servicoRepository.save(servico);
	}

	public List<Servico> getAllservice() {
		return servicoRepository.findAll();
	}

	public Servico getServiceById(Long id) {
		return servicoRepository.findById(id).orElse(null);
	}

	public void deleteService(Long id) {
		servicoRepository.deleteById(id);
	}
}
