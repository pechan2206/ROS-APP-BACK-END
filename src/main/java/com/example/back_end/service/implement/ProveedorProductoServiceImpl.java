package com.example.back_end.service.implement;

import com.example.back_end.model.ProveedorProducto;
import com.example.back_end.repository.ProveedorProductoRepository;
import com.example.back_end.service.ProveedorProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorProductoServiceImpl implements ProveedorProductoService {

    @Autowired
    private ProveedorProductoRepository proveedorProductoRepository;

    @Override
    public List<ProveedorProducto> listar(){
        return proveedorProductoRepository.findAll();
    }

    @Override
    public Optional<ProveedorProducto> obtenerPorId(Integer id){
        return proveedorProductoRepository.findById(id);
    }

    @Override
    public ProveedorProducto guardar(ProveedorProducto menuCategoria){
        return proveedorProductoRepository.save(menuCategoria);
    }

    @Override
    public void eliminar(Integer id){
        proveedorProductoRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public ProveedorProducto actualizar(Integer id, ProveedorProducto menuCategoria){
        return proveedorProductoRepository.save(menuCategoria);
    }
}
