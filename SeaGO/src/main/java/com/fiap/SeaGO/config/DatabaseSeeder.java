package com.fiap.SeaGO.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.fiap.SeaGO.model.Seago;
import com.fiap.SeaGO.repository.SeagoRepository;

@Configuration
@Profile("dev")
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    SeagoRepository seagoRepository;

    @Override
    public void run(String... args) throws Exception {
        seagoRepository.saveAll(
            List.of(
            Seago.builder()
                    .id(1L)
                    .email("seago.org@gmail.com")
                    .site("http:seagoia.com.br")
                    .telefone("+55 11 11111-1111")
                    .status("Ativa")
                    .descricao("A melhor solução na área de navegação")
                    .build()
        ));
    }
}