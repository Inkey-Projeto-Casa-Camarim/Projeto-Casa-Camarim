package com.casa_camarim.runner;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.casa_camarim.entities.Servico;
import com.casa_camarim.entities.TipoUsuario;
import com.casa_camarim.repositories.ServicoRepository;
import com.casa_camarim.repositories.TipoUsuarioRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final ServicoRepository servicoRepo;
    private final TipoUsuarioRepository tipoRepo;

    public DataLoader(ServicoRepository servicoRepo, TipoUsuarioRepository tipoRepo) {
        this.servicoRepo = servicoRepo;
        this.tipoRepo = tipoRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (servicoRepo.count() == 0) {
            servicoRepo.save(new Servico("Corte Simples", new BigDecimal("50.00"), 30));
            servicoRepo.save(new Servico("Escova", new BigDecimal("80.00"), 45));
            servicoRepo.save(new Servico("Manicure", new BigDecimal("40.00"), 40));
        }
        if (tipoRepo.count() == 0) {
            tipoRepo.save(new TipoUsuario("administrador", "senha123"));
        }
    }
}

