package com.example.back_end.service.implement;

import com.example.back_end.model.Permiso;
import com.example.back_end.repository.PermisoRepository;
import com.example.back_end.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisoServiceImpl implements PermisoService {

    @Autowired
    private PermisoRepository pedidoRepository;

    @Override
    public List<Permiso> listar(){
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Permiso> obtenerPorId(Integer id){
        return pedidoRepository.findById(id);
    }

    @Override
    public Permiso guardar(Permiso menuCategoria){
        return pedidoRepository.save(menuCategoria);
    }

    @Override
    public void eliminar(Integer id){
        pedidoRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public Permiso actualizar(Integer id, Permiso menuCategoria){
        return pedidoRepository.save(menuCategoria);
    }
}
