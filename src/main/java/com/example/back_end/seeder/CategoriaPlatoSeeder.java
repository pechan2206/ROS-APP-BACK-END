package com.example.back_end.seeder;

import com.example.back_end.model.CategoriaPlato;
import com.example.back_end.repository.CategoriaPlatoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoriaPlatoSeeder {

    @Bean
    CommandLineRunner seedCategoriasPlato(CategoriaPlatoRepository categoriaPlatoRepository) {
        return args -> {
            if (categoriaPlatoRepository.count() == 0) {
                categoriaPlatoRepository.save(new CategoriaPlato(null, "Entradas", "Platos ligeros para comenzar"));
                categoriaPlatoRepository.save(new CategoriaPlato(null, "Principales", "Platos principales del menú"));
                categoriaPlatoRepository.save(new CategoriaPlato(null, "Postres", "Dulces y postres del restaurante"));
                categoriaPlatoRepository.save(new CategoriaPlato(null, "Bebidas", "Bebidas frías y calientes"));
            }
        };
    }
}
