package com.example.back_end.service.implement;

import com.example.back_end.model.Ingreso;
import com.example.back_end.model.MetodoPago;
import com.example.back_end.repository.IngresoRepository;
import com.example.back_end.repository.MetodoPagoRepository;
import com.example.back_end.service.IngresoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngresoServiceImpl implements IngresoService {

    private final IngresoRepository ingresoRepository;
    private final MetodoPagoRepository metodoPagoRepository;

    public IngresoServiceImpl(IngresoRepository ingresoRepository, MetodoPagoRepository metodoPagoRepository) {
        this.ingresoRepository = ingresoRepository;
        this.metodoPagoRepository = metodoPagoRepository;
    }

    @Override
    public List<Ingreso> findAll() {
        return ingresoRepository.findAll();
    }

    @Override
    public Optional<Ingreso> findById(Integer id) {
        return ingresoRepository.findById(id);
    }

    @Override
    public Ingreso save(Ingreso ingreso) {

        MetodoPago metodoPago = metodoPagoRepository.findById(
                ingreso.getMetodoPago().getIdMetodo()
        ).orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));

        ingreso.setMetodoPago(metodoPago);

        return ingresoRepository.save(ingreso);
    }

    @Override
    public Ingreso update(Integer id, Ingreso ingreso) {

        return ingresoRepository.findById(id)
                .map(existing -> {

                    existing.setMonto(ingreso.getMonto());
                    existing.setDescripcion(ingreso.getDescripcion());
                    existing.setFecha(ingreso.getFecha());

                    MetodoPago metodoPago = metodoPagoRepository.findById(
                            ingreso.getMetodoPago().getIdMetodo()
                    ).orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));

                    existing.setMetodoPago(metodoPago);

                    return ingresoRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Ingreso no encontrado"));
    }

    @Override
    public void delete(Integer id) {
        ingresoRepository.deleteById(id);
    }
}
