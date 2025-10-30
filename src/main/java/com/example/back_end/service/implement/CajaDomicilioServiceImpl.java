package com.example.back_end.service.implement;

import com.example.back_end.model.CajaDomicilio;
import com.example.back_end.repository.CajaDomicilioRepository;
import com.example.back_end.service.CajaDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CajaDomicilioServiceImpl implements CajaDomicilioService {

    @Autowired
    private CajaDomicilioRepository cajaDomicilioRepository;

    @Override
    public List<CajaDomicilio>listar(){
        return cajaDomicilioRepository.findAll();
    }

    @Override
    public Optional<CajaDomicilio> obtenerPorId(Integer id){
        return cajaDomicilioRepository.findById(id);
    }

    @Override
    public CajaDomicilio guardar(CajaDomicilio cajaDomicilio){
        return cajaDomicilioRepository.save(cajaDomicilio);
    }

    @Override
    public void eliminar(Integer id){
        cajaDomicilioRepository.deleteById(id);
    }


    //Modificar para mejorar la logica
    @Override
    public CajaDomicilio actualizar(Integer id, CajaDomicilio cajaDomicilio){
        return cajaDomicilioRepository.save(cajaDomicilio);
    }



}
