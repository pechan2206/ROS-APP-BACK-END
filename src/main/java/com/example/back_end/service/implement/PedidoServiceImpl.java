package com.example.back_end.service.implement;

import com.example.back_end.model.Pedido;
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

    @Override
    public List<Pedido> listar(){
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> obtenerPorId(Integer id){
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido guardar(Pedido menuCategoria){
        return pedidoRepository.save(menuCategoria);
    }

    @Override
    public void eliminar(Integer id){
        pedidoRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public Pedido actualizar(Integer id, Pedido menuCategoria){
        return pedidoRepository.save(menuCategoria);
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
