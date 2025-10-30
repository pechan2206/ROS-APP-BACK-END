package com.example.back_end.service.implement;

import com.example.back_end.model.RolPermiso;
import com.example.back_end.repository.RolPermisoRepository;
import com.example.back_end.service.RolPermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolPermisoServiceImpl implements RolPermisoService {

    @Autowired
    private RolPermisoRepository rolPermisoRepository;

    @Override
    public List<RolPermiso> listar(){
        return rolPermisoRepository.findAll();
    }

    @Override
    public Optional<RolPermiso> obtenerPorId(Integer id){
        return rolPermisoRepository.findById(id);
    }

    @Override
    public RolPermiso guardar(RolPermiso rolPermiso){
        return rolPermisoRepository.save(rolPermiso);
    }

    @Override
    public void eliminar(Integer id){
        rolPermisoRepository.deleteById(id);
    }

    //Modificar funcionalidad
    @Override
    public RolPermiso actualizar(Integer id, RolPermiso rolPermiso){
        return rolPermisoRepository.save(rolPermiso);
    }
}
