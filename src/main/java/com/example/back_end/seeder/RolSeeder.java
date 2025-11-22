package com.example.back_end.seeder;

import com.example.back_end.model.Rol;
import com.example.back_end.repository.RolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RolSeeder {

    @Bean
    CommandLineRunner seedRoles(RolRepository rolRepository) {
        return args -> {
            if(rolRepository.count() == 0) {
                rolRepository.save(new Rol(null, "Administrador", "Acceso total al sistema"));
                rolRepository.save(new Rol(null, "Mesero", "Gestiona pedidos y mesas"));
                rolRepository.save(new Rol(null, "Cocinero", "Prepara pedidos"));
                rolRepository.save(new Rol(null, "Cajero", "Gestiona pagos y facturación"));
            }
        };
    }
}
