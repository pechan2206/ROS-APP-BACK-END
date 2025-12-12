package com.example.back_end.seeder;

import com.example.back_end.model.Ingreso;
import com.example.back_end.model.MetodoPago;
import com.example.back_end.repository.IngresoRepository;
import com.example.back_end.repository.MetodoPagoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;

@Configuration
public class IngresoSeeder {

    @Bean
    @Order(14)
    CommandLineRunner seedIngresos(IngresoRepository ingresoRepository,
                                   MetodoPagoRepository metodoPagoRepository) {
        return args -> {
            if (ingresoRepository.count() == 0) {

                // Obtener métodos de pago
                MetodoPago efectivo = metodoPagoRepository.findByNombre("Efectivo").orElseThrow();
                MetodoPago tarjeta = metodoPagoRepository.findByNombre("Tarjeta").orElseThrow();

                // Crear ingresos
                ingresoRepository.save(new Ingreso(
                        null,
                        150.50,
                        "Venta de comida día 1",
                        LocalDate.now().minusDays(3),
                        efectivo
                ));

                ingresoRepository.save(new Ingreso(
                        null,
                        200.75,
                        "Venta de comida día 2",
                        LocalDate.now().minusDays(2),
                        tarjeta
                ));

                ingresoRepository.save(new Ingreso(
                        null,
                        80.25,
                        "Venta de bebidas",
                        LocalDate.now().minusDays(1),
                        efectivo
                ));
            }
        };
    }
}
