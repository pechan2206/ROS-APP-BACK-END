package com.example.back_end.seeder;

import com.example.back_end.model.CategoriaInsumo;
import com.example.back_end.repository.CategoriaInsumoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class CategoriaInsumoSeeder {

    @Bean
    @Order(3)
    CommandLineRunner seedCategoriasInsumo(CategoriaInsumoRepository categoriaInsumoRepository) {
        return args -> {
            if (categoriaInsumoRepository.count() == 0) {
                categoriaInsumoRepository.save(new CategoriaInsumo(
                        null,
                        "Verduras",
                        "Insumos vegetales para la preparación de platos"
                ));

                categoriaInsumoRepository.save(new CategoriaInsumo(
                        null,
                        "Carnes",
                        "Insumos de origen animal para preparar carnes y proteínas"
                ));

                categoriaInsumoRepository.save(new CategoriaInsumo(
                        null,
                        "Lácteos",
                        "Insumos derivados de la leche como queso y crema"
                ));
            }
        };
    }
}
