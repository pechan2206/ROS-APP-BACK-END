package com.example.back_end.service.implement;

import com.example.back_end.model.Cliente;
import com.example.back_end.model.Pedido;
import com.example.back_end.repository.ClienteRepository;
import com.example.back_end.repository.PedidoRepository;
import com.example.back_end.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Pedido> listar(){
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> obtenerPorId(Integer id){
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido guardar(Pedido pedido) {

        // Buscar cliente por teléfono antes de guardar
        if (pedido.getCliente() != null && pedido.getCliente().getTelefono() != null) {
            Cliente clienteExistente = clienteRepository.findByTelefono(pedido.getCliente().getTelefono());

            if (clienteExistente != null) {
                pedido.setCliente(clienteExistente);
            } else {
                // Si no existe, lo puedes crear automáticamente
                Cliente nuevo = clienteRepository.save(pedido.getCliente());
                pedido.setCliente(nuevo);
            }
        }

        return pedidoRepository.save(pedido);
    }


    @Override
    public void eliminar(Integer id){
        pedidoRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public Pedido actualizar(Integer id, Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> listarPorMesa(Integer idMesa) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorMesa'");
    }

    @Override
    public List<Pedido> listarPorRangoFechas(Date desde, Date hasta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorRangoFechas'");
    }
}
