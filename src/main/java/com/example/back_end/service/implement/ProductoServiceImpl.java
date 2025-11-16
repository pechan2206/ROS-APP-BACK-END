package com.example.back_end.service.implement;

import com.example.back_end.model.Producto;
import com.example.back_end.repository.ProductoRepository;
import com.example.back_end.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listar(){
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> obtenerPorId(Integer id){
        return productoRepository.findById(id);
    }

    @Override
    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }

    @Override
    public void eliminar(Integer id){
        productoRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public Producto actualizar(Integer id, Producto producto){
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorNombre'");
    }
}
