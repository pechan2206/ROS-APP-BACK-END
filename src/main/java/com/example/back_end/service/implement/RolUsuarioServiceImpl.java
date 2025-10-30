package com.example.back_end.service.implement;

import com.example.back_end.model.RolUsuario;
import com.example.back_end.repository.RolUsuarioRepository;
import com.example.back_end.service.RolUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolUsuarioServiceImpl implements RolUsuarioService {

    @Autowired
    private RolUsuarioRepository rolUsuarioRepository;

    @Override
    public List<RolUsuario> listar(){
        return rolUsuarioRepository.findAll();
    }

    @Override
    public Optional<RolUsuario> obtenerPorId(Integer id){
        return rolUsuarioRepository.findById(id);
    }

    @Override
    public RolUsuario guardar(RolUsuario rolUsuario){
        return rolUsuarioRepository.save(rolUsuario);
    }

    @Override
    public void eliminar(Integer id){
        rolUsuarioRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public RolUsuario actualizar(Integer id, RolUsuario rolUsuario){
        return rolUsuarioRepository.save(rolUsuario);
    }
}
