package com.example.back_end.service.implement;

import com.example.back_end.model.DetallePedido;
import com.example.back_end.model.Pedido;
import com.example.back_end.model.Plato;
import com.example.back_end.repository.DetallePedidoRepository;
import com.example.back_end.repository.PedidoRepository;
import com.example.back_end.repository.PlatoRepository;
import com.example.back_end.service.DetallePedidoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

        DetallePedido saved = detallePedidoRepository.save(detallePedido);

        // Recalcular total del pedido sumando todos sus detalles
        recalcularTotalPedido(pedido.getIdPedido());

        return saved;
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

                    DetallePedido updated = detallePedidoRepository.save(existing);

                    // ← ESTO ES LO QUE FALTABA: recalcular el total del pedido
                    recalcularTotalPedido(pedido.getIdPedido());

                    return updated;
                })
                .orElseThrow(() -> new RuntimeException("Detalle de pedido no encontrado"));
    }

    @Override
    public void delete(Integer id) {
        // Obtener el pedido antes de eliminar para poder recalcular
        DetallePedido detalle = detallePedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de pedido no encontrado"));

        Integer idPedido = detalle.getPedido().getIdPedido();

        detallePedidoRepository.deleteById(id);

        // Recalcular total después de eliminar
        recalcularTotalPedido(idPedido);
    }

    @Override
    public List<DetallePedido> obtenerDetallesPorPedidoId(Integer pedidoId) {
        return detallePedidoRepository.findByPedidoId(pedidoId);
    }

    // ── Método auxiliar — suma todos los subtotales del pedido y actualiza ──
    private void recalcularTotalPedido(Integer idPedido) {
        List<DetallePedido> detalles = detallePedidoRepository.findByPedidoId(idPedido);

        BigDecimal nuevoTotal = detalles.stream()
                .map(d -> {
                    if (d.getSubtotal() != null) return d.getSubtotal();
                    if (d.getPrecioUnitario() != null)
                        return d.getPrecioUnitario().multiply(BigDecimal.valueOf(d.getCantidad()));
                    return BigDecimal.ZERO;
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        pedidoRepository.findById(idPedido).ifPresent(pedido -> {
            pedido.setTotal(nuevoTotal);
            pedidoRepository.save(pedido);
        });
    }
}