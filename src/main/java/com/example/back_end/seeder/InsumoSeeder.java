package com.example.back_end.seeder;

import com.example.back_end.model.CategoriaInsumo;
import com.example.back_end.model.Insumo;
import com.example.back_end.repository.CategoriaInsumoRepository;
import com.example.back_end.repository.InsumoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsumoSeeder {

    @Bean
    CommandLineRunner seedInsumos(InsumoRepository insumoRepository,
                                  CategoriaInsumoRepository categoriaRepository) {
        return args -> {

            if (insumoRepository.count() > 0) {
                System.out.println("Insumos ya existen, se omite seeding.");
                return;
            }

            // --- Categorías necesarias ---
            CategoriaInsumo categoriaVerdura = categoriaRepository
                    .findByNombre("Verduras")
                    .orElseGet(() -> {
                        System.out.println("Creando categoría Verdura...");
                        return categoriaRepository.save(new CategoriaInsumo(null, "Verdura", "Verduras frescas"));
                    });

            CategoriaInsumo categoriaCarne = categoriaRepository
                    .findByNombre("Carnes")
                    .orElseGet(() -> {
                        System.out.println("Creando categoría Carne...");
                        return categoriaRepository.save(new CategoriaInsumo(null, "Carne", "Carnes seleccionadas"));
                    });

            // --- Crear Insumos ---
            Insumo tomate = new Insumo(
                    null,
                    "Tomate",
                    10.0,
                    "kg",
                    categoriaVerdura
            );

            Insumo pollo = new Insumo(
                    null,
                    "Pollo",
                    5.0,
                    "kg",
                    categoriaCarne
            );

            Insumo lechuga = new Insumo(
                    null,
                    "Lechuga",
                    3.0,
                    "kg",
                    categoriaVerdura
            );

            // Guardar insumos
            insumoRepository.saveAll(java.util.List.of(tomate, pollo, lechuga));

            System.out.println("Insumos seed completado ✅");
        };
    }
}
