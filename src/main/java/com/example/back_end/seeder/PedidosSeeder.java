package com.example.back_end.seeder;

import com.example.back_end.model.Mesa;
import com.example.back_end.model.Pedido;
import com.example.back_end.model.Cliente;
import com.example.back_end.model.enums.EstadoPedido;
import com.example.back_end.model.enums.TipoPedido;
import com.example.back_end.repository.MesaRepository;
import com.example.back_end.repository.PedidoRepository;
import com.example.back_end.repository.UsuarioRepository;
import com.example.back_end.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class PedidosSeeder {

    @Bean
    @Order(10)
    CommandLineRunner seedPedidos(PedidoRepository pedidoRepository,
                                  MesaRepository mesaRepository,
                                  UsuarioRepository usuarioRepository,
                                  ClienteRepository clienteRepository) {
        return args -> {
            if (pedidoRepository.count() == 0) {

                Cliente cliente1 = clienteRepository.findById(1).orElseThrow();

                Mesa mesa1 = mesaRepository.findById(1).orElseThrow();
                Mesa mesa2 = mesaRepository.findById(2).orElseThrow();

                // null al final = detallePedidos vacío (se agregan después)
                pedidoRepository.save(new Pedido(
                        null, mesa1, cliente1, null,
                        EstadoPedido.Pendiente, 0.0, TipoPedido.Mesa, null
                ));

                pedidoRepository.save(new Pedido(
                        null, mesa2, cliente1, null,
                        EstadoPedido.En_preparacion, 0.0, TipoPedido.Mesa, null
                ));

                pedidoRepository.save(new Pedido(
                        null, null, cliente1, null,
                        EstadoPedido.Entregado, 0.0, TipoPedido.Domicilio, null
                ));

                pedidoRepository.save(new Pedido(
                        null, null, cliente1, null,
                        EstadoPedido.Anulado, 0.0, TipoPedido.Llevar, null
                ));
            }
        };
    }
}