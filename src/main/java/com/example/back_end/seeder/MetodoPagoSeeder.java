package com.example.back_end.seeder;

import com.example.back_end.model.MetodoPago;
import com.example.back_end.repository.MetodoPagoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class MetodoPagoSeeder {

    @Bean
    @Order(9) // Orden recomendado según dependencias
    CommandLineRunner seedMetodosPago(MetodoPagoRepository metodoPagoRepository) {
        return args -> {
            if (metodoPagoRepository.count() == 0) {
                metodoPagoRepository.save(new MetodoPago(null, "Efectivo"));
                metodoPagoRepository.save(new MetodoPago(null, "Tarjeta Crédito"));
                metodoPagoRepository.save(new MetodoPago(null, "Tarjeta Débito"));
                metodoPagoRepository.save(new MetodoPago(null, "Nequi"));
                metodoPagoRepository.save(new MetodoPago(null, "Daviplata"));
            }
        };
    }
}
