package com.example.back_end.service.implement;

import com.example.back_end.model.Mesa;
import com.example.back_end.repository.MesaRepository;
import com.example.back_end.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaServiceImpl implements MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    @Override
    public List<Mesa> listar(){
        return mesaRepository.findAll();
    }

    @Override
    public Optional<Mesa> obtenerPorId(Integer id){
        return mesaRepository.findById(id);
    }

    @Override
    public Mesa guardar(Mesa mesa){
        return mesaRepository.save(mesa);
    }

    @Override
    public void eliminar(Integer id){
        mesaRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public Mesa actualizar(Integer id, Mesa mesa){
        return mesaRepository.save(mesa);
    }
}
