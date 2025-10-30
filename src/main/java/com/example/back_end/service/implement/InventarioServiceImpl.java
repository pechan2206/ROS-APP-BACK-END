package com.example.back_end.service.implement;

import com.example.back_end.model.Inventario;
import com.example.back_end.repository.InventarioRepository;
import com.example.back_end.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private InventarioRepository inventarioRepositor;

    @Override
    public List<Inventario> listar(){
        return inventarioRepositor.findAll();
    }

    @Override
    public Optional<Inventario> obtenerPorId(Integer id){
        return inventarioRepositor.findById(id);
    }

    @Override
    public Inventario guardar(Inventario inventario){
        return inventarioRepositor.save(inventario);
    }

    @Override
    public void eliminar(Integer id){
        inventarioRepositor.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public Inventario actualizar(Integer id, Inventario inventario){
        return inventarioRepositor.save(inventario);
    }
}
