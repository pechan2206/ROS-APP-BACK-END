package com.example.back_end.service.implement;

import com.example.back_end.model.MetodoPago;
import com.example.back_end.repository.MetodoPagoRepository;
import com.example.back_end.service.MetodoPagoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {

    private final MetodoPagoRepository metodoPagoRepository;

    public MetodoPagoServiceImpl(MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
    }

    @Override
    public List<MetodoPago> findAll() {
        return metodoPagoRepository.findAll();
    }

    @Override
    public Optional<MetodoPago> findById(Integer id) {
        return metodoPagoRepository.findById(id);
    }

    @Override
    public MetodoPago save(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    @Override
    public MetodoPago update(Integer id, MetodoPago metodoPago) {
        return metodoPagoRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(metodoPago.getNombre());
                    return metodoPagoRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));
    }

    @Override
    public void delete(Integer id) {
        metodoPagoRepository.deleteById(id);
    }
}
