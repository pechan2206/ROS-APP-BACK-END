package com.example.back_end.seeder;

import com.example.back_end.model.Mesa;
import com.example.back_end.model.Pedido;
import com.example.back_end.model.Usuario;
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


                pedidoRepository.save(new Pedido(
                        null,           // id_pedido
                        mesa1,          // mesa
                        cliente1,       // cliente
                        null,           // fecha -> la BD la pone
                        EstadoPedido.Pendiente,
                        0.0,            // total -> luego se recalcula por triggers
                        TipoPedido.Mesa
                ));

                pedidoRepository.save(new Pedido(
                        null,
                        mesa2,
                        cliente1,
                        null,
                        EstadoPedido.En_preparación,
                        0.0,
                        TipoPedido.Mesa
                ));

                pedidoRepository.save(new Pedido(
                        null,
                        null,           // no tiene mesa
                        cliente1,
                        null,
                        EstadoPedido.Entregado,
                        0.0,
                        TipoPedido.Domicilio
                ));

                pedidoRepository.save(new Pedido(
                        null,
                        null,
                        cliente1,
                        null,
                        EstadoPedido.Cancelado,
                        0.0,
                        TipoPedido.Llevar
                ));

            }
        };
    }
}
