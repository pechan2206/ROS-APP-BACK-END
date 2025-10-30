package com.example.back_end.service.implement;

import com.example.back_end.model.Factura;
import com.example.back_end.repository.FacturaRepository;
import com.example.back_end.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public List<Factura> listar(){
        return facturaRepository.findAll();
    }

    @Override
    public Optional<Factura> obtenerPorId(Integer id){
        return facturaRepository.findById(id);
    }

    @Override
    public Factura guardar(Factura documento){
        return facturaRepository.save(documento);
    }

    @Override
    public void eliminar(Integer id){
        facturaRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public Factura actualizar(Integer id, Factura documento){
        return facturaRepository.save(documento);
    }
}

