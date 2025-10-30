package com.example.back_end.service.implement;

import com.example.back_end.model.DetalleFactura;
import com.example.back_end.repository.DetalleFacturaRepository;
import com.example.back_end.service.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Override
    public List<DetalleFactura> listar(){
        return detalleFacturaRepository.findAll();
    }
    @Override
    public Optional<DetalleFactura> obtenerPorId(Integer id){
        return detalleFacturaRepository.findById(id);
    }
    @Override
    public DetalleFactura guardar(DetalleFactura detalleFactura){
        return detalleFacturaRepository.save(detalleFactura);
    }
    @Override
    public void eliminar(Integer id){
        detalleFacturaRepository.deleteById(id);
    }
    //modificar este
    @Override
    public DetalleFactura actualizar(Integer id, DetalleFactura detalleFactura){
        return detalleFacturaRepository.save(detalleFactura);
    }
}
