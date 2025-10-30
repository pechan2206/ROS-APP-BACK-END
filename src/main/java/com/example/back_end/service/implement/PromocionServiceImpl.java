package com.example.back_end.service.implement;

import com.example.back_end.model.Promocion;
import com.example.back_end.repository.PromocionRepository;
import com.example.back_end.service.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromocionServiceImpl implements PromocionService {

    @Autowired
    private PromocionRepository promocionRepository;

    @Override
    public List<Promocion> listar(){
        return promocionRepository.findAll();
    }

    @Override
    public Optional<Promocion> obtenerPorId(Integer id){
        return promocionRepository.findById(id);
    }

    @Override
    public Promocion guardar(Promocion promocion){
        return promocionRepository.save(promocion);
    }

    @Override
    public void eliminar(Integer id){
        promocionRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public Promocion actualizar(Integer id, Promocion promocion){
        return promocionRepository.save(promocion);
    }
}
