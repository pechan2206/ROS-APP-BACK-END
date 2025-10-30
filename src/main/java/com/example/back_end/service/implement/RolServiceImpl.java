package com.example.back_end.service.implement;

import com.example.back_end.model.Rol;
import com.example.back_end.repository.RolRepository;
import com.example.back_end.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> listar(){
        return rolRepository.findAll();
    }

    @Override
    public Optional<Rol> obtenerPorId(Integer id){
        return rolRepository.findById(id);
    }

    @Override
    public Rol guardar(Rol rol){
        return rolRepository.save(rol);
    }

    @Override
    public void eliminar(Integer id){
        rolRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public Rol actualizar(Integer id, Rol rol){
        return rolRepository.save(rol);
    }
}
