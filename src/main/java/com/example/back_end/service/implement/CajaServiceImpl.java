package com.example.back_end.service.implement;

import com.example.back_end.model.Caja;
import com.example.back_end.repository.CajaRepository;
import com.example.back_end.service.CajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CajaServiceImpl implements CajaService {

    @Autowired
    private CajaRepository cajaRepository;

    @Override
    public List<Caja> listar(){
        return cajaRepository.findAll();
    }

    @Override
    public Optional<Caja> obtenerPorId(Integer id){
        return cajaRepository.findById(id);
    }

    @Override
    public Caja guardar(Caja caja){
        return cajaRepository.save(caja);
    }

    @Override
    public void eliminar(Integer id){
        cajaRepository.deleteById(id);
    }

    @Override
    public Caja actualizar(Integer id, Caja caja){
        return cajaRepository.save(caja);
    }

}
