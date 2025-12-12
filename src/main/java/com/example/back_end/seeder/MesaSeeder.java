package com.example.back_end.seeder;

import com.example.back_end.model.Mesa;
import com.example.back_end.repository.MesaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class MesaSeeder {

    @Bean
    @Order(7)
    CommandLineRunner seedMesas(MesaRepository mesaRepository) {
        return args -> {
            if (mesaRepository.count() == 0) {
                // Ejemplo de mesas iniciales
                mesaRepository.save(new Mesa(null, 1, 4, null));
                mesaRepository.save(new Mesa(null, 2, 2, null));
                mesaRepository.save(new Mesa(null, 3, 6, null));
                mesaRepository.save(new Mesa(null, 4, 4, null));
            }
        };
    }
}
