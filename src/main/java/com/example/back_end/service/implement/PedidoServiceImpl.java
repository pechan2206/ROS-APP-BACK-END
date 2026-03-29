package com.example.back_end.service.implement;

import com.example.back_end.model.Cliente;
import com.example.back_end.model.Mesa;
import com.example.back_end.model.Pedido;
import com.example.back_end.repository.ClienteRepository;
import com.example.back_end.repository.MesaRepository;
import com.example.back_end.repository.PedidoRepository;
import com.example.back_end.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired private PedidoRepository  pedidoRepository;
    @Autowired private ClienteRepository clienteRepository;
    @Autowired private MesaRepository    mesaRepository;   // ← inyectar

    @Override
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> obtenerPorId(Integer id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido guardar(Pedido pedido) {

        // ── Validar mesa ──────────────────────────────────────────────────
        if (pedido.getMesa() != null && pedido.getMesa().getIdMesa() != null) {
            Mesa mesa = mesaRepository.findById(pedido.getMesa().getIdMesa())
                .orElseThrow(() -> new IllegalArgumentException(
                    "La mesa número " + pedido.getMesa().getIdMesa() + " no existe"
                ));
            pedido.setMesa(mesa);
        } else if ("Mesa".equalsIgnoreCase(
                pedido.getTipo() != null ? pedido.getTipo().toString() : "")) {
            throw new IllegalArgumentException("Debes indicar el número de mesa");
        }

        // ── Validar / crear cliente ───────────────────────────────────────
        if (pedido.getCliente() != null && pedido.getCliente().getTelefono() != null) {
            Cliente clienteExistente = clienteRepository
                .findByTelefono(pedido.getCliente().getTelefono());
            if (clienteExistente != null) {
                pedido.setCliente(clienteExistente);
            } else {
                Cliente nuevo = clienteRepository.save(pedido.getCliente());
                pedido.setCliente(nuevo);
            }
        }

        return pedidoRepository.save(pedido);
    }

    @Override
    public void eliminar(Integer id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public Pedido actualizar(Integer id, Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> listarPorMesa(Integer idMesa) {
        throw new UnsupportedOperationException("Unimplemented method 'listarPorMesa'");
    }

    @Override
    public List<Pedido> listarPorRangoFechas(Date desde, Date hasta) {
        throw new UnsupportedOperationException("Unimplemented method 'listarPorRangoFechas'");
    }
}