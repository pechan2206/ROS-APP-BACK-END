package com.example.back_end.seeder;

import com.example.back_end.model.Cliente;
import com.example.back_end.model.Factura;
import com.example.back_end.model.MetodoPago;
import com.example.back_end.model.Pedido;
import com.example.back_end.repository.ClienteRepository;
import com.example.back_end.repository.FacturaRepository;
import com.example.back_end.repository.MetodoPagoRepository;
import com.example.back_end.repository.PedidoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDateTime;

@Configuration
public class FacturaSeeder {

    @Bean
    @Order(12)
    CommandLineRunner seedFacturas(FacturaRepository facturaRepository,
                                   PedidoRepository pedidoRepository,
                                   ClienteRepository clienteRepository,
                                   MetodoPagoRepository metodoPagoRepository) {
        return args -> {
            if (facturaRepository.count() == 0) {

                // Pedidos
                Pedido pedido1 = pedidoRepository.findById(1).orElseGet(() -> pedidoRepository.save(new Pedido()));
                Pedido pedido2 = pedidoRepository.findById(2).orElseGet(() -> pedidoRepository.save(new Pedido()));
                Pedido pedido3 = pedidoRepository.findById(3).orElseGet(() -> pedidoRepository.save(new Pedido()));

                // Clientes
                Cliente cliente1 = clienteRepository.findById(1).orElseGet(() -> {
                    Cliente c = new Cliente();
                    c.setNombre("Cliente 1");
                    return clienteRepository.save(c);
                });
                Cliente cliente2 = clienteRepository.findById(2).orElseGet(() -> {
                    Cliente c = new Cliente();
                    c.setNombre("Cliente 2");
                    return clienteRepository.save(c);
                });
                Cliente cliente3 = clienteRepository.findById(3).orElseGet(() -> {
                    Cliente c = new Cliente();
                    c.setNombre("Cliente 3");
                    return clienteRepository.save(c);
                });

                // Métodos de pago
                MetodoPago efectivo = metodoPagoRepository.findByNombre("Efectivo").orElseGet(() -> {
                    MetodoPago m = new MetodoPago();
                    m.setNombre("Efectivo");
                    return metodoPagoRepository.save(m);
                });
                MetodoPago tarjeta = metodoPagoRepository.findByNombre("Tarjeta").orElseGet(() -> {
                    MetodoPago m = new MetodoPago();
                    m.setNombre("Tarjeta");
                    return metodoPagoRepository.save(m);
                });

                // Insertar facturas
                facturaRepository.save(new Factura(null, pedido1, cliente1, efectivo, LocalDateTime.now().minusDays(2), 50.00));
                facturaRepository.save(new Factura(null, pedido2, cliente2, tarjeta, LocalDateTime.now().minusDays(1), 80.50));
                facturaRepository.save(new Factura(null, pedido3, cliente3, efectivo, LocalDateTime.now(), 30.75));

                System.out.println("Facturas seed completado ✅");
            }
        };
    }
}
