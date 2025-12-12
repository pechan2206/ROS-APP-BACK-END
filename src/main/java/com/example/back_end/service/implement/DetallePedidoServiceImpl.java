package com.example.back_end.service.implement;

import com.example.back_end.model.DetallePedido;
import com.example.back_end.model.Pedido;
import com.example.back_end.model.Plato;
import com.example.back_end.repository.DetallePedidoRepository;
import com.example.back_end.repository.PedidoRepository;
import com.example.back_end.repository.PlatoRepository;
import com.example.back_end.service.DetallePedidoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

    private final DetallePedidoRepository detallePedidoRepository;
    private final PedidoRepository pedidoRepository;
    private final PlatoRepository platoRepository;

    public DetallePedidoServiceImpl(DetallePedidoRepository detallePedidoRepository,
                                    PedidoRepository pedidoRepository,
                                    PlatoRepository platoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
        this.pedidoRepository = pedidoRepository;
        this.platoRepository = platoRepository;
    }

    @Override
    public List<DetallePedido> findAll() {
        return detallePedidoRepository.findAll();
    }

    @Override
    public Optional<DetallePedido> findById(Integer id) {
        return detallePedidoRepository.findById(id);
    }

    @Override
    public DetallePedido save(DetallePedido detallePedido) {

        Pedido pedido = pedidoRepository.findById(
                detallePedido.getPedido().getIdPedido()
        ).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        Plato plato = platoRepository.findById(
                detallePedido.getPlato().getIdPlato()
        ).orElseThrow(() -> new RuntimeException("Plato no encontrado"));

        detallePedido.setPedido(pedido);
        detallePedido.setPlato(plato);

        System.out.println("RECIBIDO ===> " + detallePedido);
        System.out.println("PEDIDO ===> " + detallePedido.getPedido());
        System.out.println("PLATO ===> " + detallePedido.getPlato());

        return detallePedidoRepository.save(detallePedido);
    }

    @Override
    public DetallePedido update(Integer id, DetallePedido detallePedido) {

        return detallePedidoRepository.findById(id)
                .map(existing -> {

                    existing.setCantidad(detallePedido.getCantidad());
                    existing.setPrecioUnitario(detallePedido.getPrecioUnitario());
                    existing.setSubtotal(detallePedido.getSubtotal());

                    Pedido pedido = pedidoRepository.findById(
                            detallePedido.getPedido().getIdPedido()
                    ).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

                    Plato plato = platoRepository.findById(
                            detallePedido.getPlato().getIdPlato()
                    ).orElseThrow(() -> new RuntimeException("Plato no encontrado"));

                    existing.setPedido(pedido);
                    existing.setPlato(plato);

                    return detallePedidoRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Detalle de pedido no encontrado"));
    }

    @Override
    public void delete(Integer id) {
        detallePedidoRepository.deleteById(id);
    }

    @Override
    public List<DetallePedido> obtenerDetallesPorPedidoId(Integer pedidoId) {
        return detallePedidoRepository.findByPedidoId(pedidoId);
    }

}
