package com.example.back_end.seeder;

import com.example.back_end.model.DetallePedido;
import com.example.back_end.model.Pedido;
import com.example.back_end.model.Plato;
import com.example.back_end.repository.DetallePedidoRepository;
import com.example.back_end.repository.PedidoRepository;
import com.example.back_end.repository.PlatoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Optional;

@Configuration
public class DetallePedidoSeeder {

    @Bean
    CommandLineRunner seedDetallePedidos(DetallePedidoRepository detallePedidoRepository,
                                         PedidoRepository pedidoRepository,
                                         PlatoRepository platoRepository) {
        return args -> {
            if (detallePedidoRepository.count() == 0) {

                // Obtener pedidos existentes (o crear si no existen)
                Pedido pedido1 = pedidoRepository.findById(1).orElseGet(() -> pedidoRepository.save(new Pedido()));
                Pedido pedido2 = pedidoRepository.findById(2).orElseGet(() -> pedidoRepository.save(new Pedido()));
                Pedido pedido3 = pedidoRepository.findById(3).orElseGet(() -> pedidoRepository.save(new Pedido()));

                // Obtener platos existentes
                Optional<Plato> plato1Opt = platoRepository.findById(1);
                Optional<Plato> plato2Opt = platoRepository.findById(2);
                Optional<Plato> plato3Opt = platoRepository.findById(3);

                if (plato1Opt.isEmpty() || plato2Opt.isEmpty() || plato3Opt.isEmpty()) {
                    throw new RuntimeException("Los platos necesarios no existen. Crea primero los platos.");
                }

                Plato plato1 = plato1Opt.get();
                Plato plato2 = plato2Opt.get();
                Plato plato3 = plato3Opt.get();

                // Crear detalles de pedido
// Crear detalles de pedido
                DetallePedido dp1 = new DetallePedido(
                        null,                 // id
                        pedido1,
                        plato1,
                        2,                    // cantidad
                        null,                 // precio_unitario -> lo pone el trigger
                        null                  // subtotal -> lo puedes poner con otro trigger o en backend
                );

                DetallePedido dp2 = new DetallePedido(
                        null,
                        pedido2,
                        plato2,
                        1,
                        null,
                        null
                );

                DetallePedido dp3 = new DetallePedido(
                        null,
                        pedido3,
                        plato3,
                        3,
                        null,
                        null
                );

                // Guardar detalles
                detallePedidoRepository.save(dp1);
                detallePedidoRepository.save(dp2);
                detallePedidoRepository.save(dp3);

            }
        };
    }
}
