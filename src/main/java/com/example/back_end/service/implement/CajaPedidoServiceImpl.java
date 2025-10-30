package com.example.back_end.service.implement;

import com.example.back_end.model.CajaPedido;
import com.example.back_end.repository.CajaPedidoRepository;
import com.example.back_end.service.CajaPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CajaPedidoServiceImpl implements CajaPedidoService {

    @Autowired
    private CajaPedidoRepository cajaPedidoRepository;

    @Override
    public List<CajaPedido> listar(){
        return cajaPedidoRepository.findAll();
    }

    @Override
    public Optional<CajaPedido> obtenerPorId(Integer id){
        return cajaPedidoRepository.findById(id);
    }

    @Override
    public CajaPedido guardar(CajaPedido cajaPedido){
        return cajaPedidoRepository.save(cajaPedido);
    }

    @Override
    public void eliminar(Integer id){
        cajaPedidoRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public CajaPedido actualizar(Integer id, CajaPedido cajaPedido){
        return cajaPedidoRepository.save(cajaPedido);
    }
}
