package com.example.back_end.service.implement;

import com.example.back_end.model.Pago;
import com.example.back_end.repository.PagoRepository;
import com.example.back_end.service.PagoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Override
    public List<Pago> listar(){
        return pagoRepository.findAll();
    }

    @Override
    public Optional<Pago> obtenerPorId(Integer id){
        return pagoRepository.findById(id);
    }

    @Override
    public Pago guardar(Pago menuCategoria){
        return pagoRepository.save(menuCategoria);
    }

    @Override
    public void eliminar(Integer id){
        pagoRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public Pago actualizar(Integer id, Pago menuCategoria){
        return pagoRepository.save(menuCategoria);
    }
}
