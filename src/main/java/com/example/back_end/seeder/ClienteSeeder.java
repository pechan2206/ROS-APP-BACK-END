package com.example.back_end.seeder;

import com.example.back_end.model.Cliente;
import com.example.back_end.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;

@Configuration
public class ClienteSeeder {

    @Bean
    @Order(8)
    CommandLineRunner seedClientes(ClienteRepository clienteRepository) {
        return args -> {
            if (clienteRepository.count() == 0) {
                clienteRepository.save(new Cliente(
                        null,
                        "Juan Pérez",
                        "3001112222",
                        "juan.perez@gmail.com",
                        "Calle 123 #45-67",
                        "Torre 14 apto 604",
                        LocalDate.now().minusDays(10).atStartOfDay()
                ));

                clienteRepository.save(new Cliente(
                        null,
                        "María Gómez",
                        "3003334444",
                        "maria.gomez@gmail.com",
                        "Carrera 78 #12-34",
                        "Casa 11 interior 11",
                        LocalDate.now().minusDays(8).atStartOfDay()
                ));

                clienteRepository.save(new Cliente(
                        null,
                        "Carlos Ramírez",
                        "3005556666",
                        "carlos.ramirez@gmail.com",
                        "Avenida Siempre Viva 742",
                        "C2T11 torre 15 apto 13",
                        LocalDate.now().minusDays(5).atStartOfDay()
                ));
            }
        };
    }
}
