package com.example.back_end.seeder;

import com.example.back_end.model.Mesa;
import com.example.back_end.model.Pedido;
import com.example.back_end.model.Usuario;
import com.example.back_end.model.Cliente;
import com.example.back_end.model.enums.EstadoPedido;
import com.example.back_end.repository.MesaRepository;
import com.example.back_end.repository.PedidoRepository;
import com.example.back_end.repository.UsuarioRepository;
import com.example.back_end.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class PedidosSeeder {

    @Bean
    CommandLineRunner seedPedidos(PedidoRepository pedidoRepository,
                                  MesaRepository mesaRepository,
                                  UsuarioRepository usuarioRepository,
                                  ClienteRepository clienteRepository) {
        return args -> {
            if (pedidoRepository.count() == 0) {

                // Tomar referencias
                Usuario mesero = usuarioRepository.findByCorreo("admin@restaurante.com").orElseThrow();
                Cliente cliente1 = clienteRepository.findById(1).orElseThrow();

                // Pedidos
                Mesa mesa1 = mesaRepository.findById(1).orElseThrow();
                Mesa mesa2 = mesaRepository.findById(2).orElseThrow();
                Mesa mesa3 = mesaRepository.findById(3).orElseThrow();
                Mesa mesa4 = mesaRepository.findById(4).orElseThrow();

                pedidoRepository.save(new Pedido(null, mesa1, mesero, cliente1, LocalDateTime.now(), EstadoPedido.Pendiente, 0.0));
                pedidoRepository.save(new Pedido(null, mesa2, mesero, cliente1, LocalDateTime.now(), EstadoPedido.En_preparación, 0.0));
                pedidoRepository.save(new Pedido(null, mesa3, mesero, cliente1, LocalDateTime.now(), EstadoPedido.Entregado, 0.0));
                pedidoRepository.save(new Pedido(null, mesa4, mesero, cliente1, LocalDateTime.now(), EstadoPedido.Cancelado, 0.0));
            }
        };
    }
}
