package com.example.back_end.service.implement;

import com.example.back_end.model.Domicilio;
import com.example.back_end.repository.DomicilioRepository;
import com.example.back_end.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServiceImpl implements DomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Override
    public List<Domicilio> listar(){
        return domicilioRepository.findAll();
    }

    @Override
    public Optional<Domicilio> obtenerPorId(Integer id){
        return domicilioRepository.findById(id);
    }

    @Override
    public Domicilio guardar(Domicilio domicilio){
        return domicilioRepository.save(domicilio);
    }

    @Override
    public void eliminar(Integer id){
        domicilioRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public Domicilio actualizar(Integer id, Domicilio domicilio){
        return domicilioRepository.save(domicilio);
    }
}


