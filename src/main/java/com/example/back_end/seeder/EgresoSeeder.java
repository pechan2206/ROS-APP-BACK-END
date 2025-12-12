package com.example.back_end.seeder;

import com.example.back_end.model.Egreso;
import com.example.back_end.model.MetodoPago;
import com.example.back_end.repository.EgresoRepository;
import com.example.back_end.repository.MetodoPagoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;

@Configuration
public class EgresoSeeder {

    @Bean
    @Order(15)
    CommandLineRunner seedEgresos(EgresoRepository egresoRepository,
                                  MetodoPagoRepository metodoPagoRepository) {
        return args -> {
            if (egresoRepository.count() == 0) {

                // Obtener métodos de pago
                MetodoPago efectivo = metodoPagoRepository.findByNombre("Efectivo").orElseThrow();
                MetodoPago tarjeta = metodoPagoRepository.findByNombre("Tarjeta").orElseThrow();

                // Crear egresos
                egresoRepository.save(new Egreso(
                        null,
                        50.25,
                        "Compra de verduras frescas",
                        LocalDate.now().minusDays(3),
                        efectivo
                ));

                egresoRepository.save(new Egreso(
                        null,
                        120.75,
                        "Compra de carnes para la semana",
                        LocalDate.now().minusDays(2),
                        tarjeta
                ));

                egresoRepository.save(new Egreso(
                        null,
                        75.50,
                        "Compra de leche y queso",
                        LocalDate.now().minusDays(1),
                        efectivo
                ));
            }
        };
    }
}
