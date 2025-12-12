package com.example.back_end.seeder;

import com.example.back_end.model.Proveedor;
import com.example.back_end.repository.ProveedorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class ProveedorSeeder {

    @Bean
    @Order(16)
    CommandLineRunner seedProveedores(ProveedorRepository proveedorRepository) {
        return args -> {
            if (proveedorRepository.count() == 0) {
                proveedorRepository.save(new Proveedor(
                        null,
                        "Proveedor de Verduras",
                        "3001112233",
                        "verduras@proveedor.com",
                        "Calle 10 #20-30"
                ));

                proveedorRepository.save(new Proveedor(
                        null,
                        "Proveedor de Carnes",
                        "3002223344",
                        "carnes@proveedor.com",
                        "Carrera 5 #15-10"
                ));

                proveedorRepository.save(new Proveedor(
                        null,
                        "Proveedor de Lácteos",
                        "3003334455",
                        "lacteos@proveedor.com",
                        "Avenida Central #50-40"
                ));
            }
        };
    }
}