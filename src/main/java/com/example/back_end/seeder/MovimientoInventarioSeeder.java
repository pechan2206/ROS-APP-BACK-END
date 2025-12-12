package com.example.back_end.seeder;

import com.example.back_end.model.Insumo;
import com.example.back_end.model.MovimientoInventario;
import com.example.back_end.repository.InsumoRepository;
import com.example.back_end.repository.MovimientoInventarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDateTime;

@Configuration
public class MovimientoInventarioSeeder {

    @Bean
    @Order(17)
    CommandLineRunner seedMovimientos(MovimientoInventarioRepository movimientoRepository,
                                      InsumoRepository insumoRepository) {
        return args -> {
            if (movimientoRepository.count() == 0) {

                // Obtener insumos
                Insumo lechuga = insumoRepository.findByNombre("Lechuga").orElseThrow();
                Insumo tomate = insumoRepository.findByNombre("Tomate").orElseThrow();
                Insumo pollo = insumoRepository.findByNombre("Pollo").orElseThrow();

                // Crear movimientos
                movimientoRepository.save(new MovimientoInventario(
                        null,
                        lechuga,
                        MovimientoInventario.TipoMovimiento.Entrada,
                        10.0,
                        LocalDateTime.now().minusDays(5),
                        "Compra semanal de lechuga"
                ));

                movimientoRepository.save(new MovimientoInventario(
                        null,
                        tomate,
                        MovimientoInventario.TipoMovimiento.Entrada,
                        15.0,
                        LocalDateTime.now().minusDays(4),
                        "Compra de tomates frescos"
                ));

                movimientoRepository.save(new MovimientoInventario(
                        null,
                        pollo,
                        MovimientoInventario.TipoMovimiento.Entrada,
                        8.0,
                        LocalDateTime.now().minusDays(3),
                        "Compra de pollo para platos del menú"
                ));

                movimientoRepository.save(new MovimientoInventario(
                        null,
                        lechuga,
                        MovimientoInventario.TipoMovimiento.Salida,
                        5.0,
                        LocalDateTime.now().minusDays(2),
                        "Uso de lechuga en ensaladas"
                ));

                movimientoRepository.save(new MovimientoInventario(
                        null,
                        pollo,
                        MovimientoInventario.TipoMovimiento.Salida,
                        3.0,
                        LocalDateTime.now().minusDays(1),
                        "Preparación de platos de pollo"
                ));
            }
        };
    }
}
