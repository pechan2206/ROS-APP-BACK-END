package com.example.back_end.seeder;

import com.example.back_end.model.CategoriaPlato;
import com.example.back_end.model.Plato;
import com.example.back_end.repository.CategoriaPlatoRepository;
import com.example.back_end.repository.PlatoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class PlatoSeeder {

    @Bean
    CommandLineRunner seedPlatos(PlatoRepository platoRepository,
                                 CategoriaPlatoRepository categoriaPlatoRepository) {
        return args -> {
            if (platoRepository.count() == 0) {

                // Obtener categorías
                CategoriaPlato entradas = categoriaPlatoRepository.findByNombre("Entradas").orElseThrow();
                CategoriaPlato principales = categoriaPlatoRepository.findByNombre("Principales").orElseThrow();
                CategoriaPlato postres = categoriaPlatoRepository.findByNombre("Postres").orElseThrow();

                // Insertar platos
                platoRepository.save(new Plato(
                        null,
                        "Ensalada César",
                        BigDecimal.valueOf(12.50),
                        "Ensalada con pollo, lechuga, croutons y aderezo César",
                        null,
                        entradas
                ));

                platoRepository.save(new Plato(
                        null,
                        "Pollo a la Parrilla",
                        BigDecimal.valueOf(25.00),
                        "Pollo marinado a la parrilla acompañado de verduras",
                        null,
                        principales
                ));

                platoRepository.save(new Plato(
                        null,
                        "Pastel de Chocolate",
                        BigDecimal.valueOf(8.00),
                        "Delicioso pastel de chocolate con crema",
                        null,
                        postres
                ));
            }
        };
    }
}
