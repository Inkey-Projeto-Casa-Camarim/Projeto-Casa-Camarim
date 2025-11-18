package com.casa_camarim.config;

import com.casa_camarim.entities.Servico;
import com.casa_camarim.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ServicoRepository servicoRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== INICIANDO CARREGAMENTO DE DADOS ===");
        
        // Verificar se já existem serviços
        if (servicoRepository.count() == 0) {
            System.out.println("Cadastrando serviços iniciais...");  
           
            Servico servico1 = new Servico("Corte", "R$50,00", "45 minutos");
            Servico servico2 = new Servico("Loiro", "R$ 150,00", "120 minutos");
            Servico servico3 = new Servico("Morena iluminada", "R$ 120,00", "90 minutos");
            Servico servico4 = new Servico("Maquiagem", "R$ 80,00", "60 minutos");
            Servico servico5 = new Servico("Coloração", "R$ 90,00", "90 minutos");
            Servico servico6 = new Servico("Pedicure", "R$ 35,00", "45 minutos");
            Servico servico7 = new Servico("Manicure", "R$ 25,00", "30 minutos");
            Servico servico8 = new Servico("Sobrancelha", "R$ 20,00", "30 minutos");
            Servico servico9 = new Servico("Buço", "R$ 15,00", "15 minutos");
          	Servico servico10 = new Servico("Selagem", "R$ 100,00", "90 minutos");

                 servicoRepository.save(servico1);
                 servicoRepository.save(servico2);
                 servicoRepository.save(servico3);
                 servicoRepository.save(servico4);
                 servicoRepository.save(servico5);
                 servicoRepository.save(servico6);
                 servicoRepository.save(servico7);
                 servicoRepository.save(servico8);
                 servicoRepository.save(servico9);
                 servicoRepository.save(servico10);
            }
        }
    }
