package com.example.back_end.service.implement;

import com.example.back_end.model.Egreso;
import com.example.back_end.model.MetodoPago;
import com.example.back_end.repository.EgresoRepository;
import com.example.back_end.repository.MetodoPagoRepository;
import com.example.back_end.service.EgresoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EgresoServiceImpl implements EgresoService {

    private final EgresoRepository egresoRepository;
    private final MetodoPagoRepository metodoPagoRepository;

    public EgresoServiceImpl(EgresoRepository egresoRepository, MetodoPagoRepository metodoPagoRepository) {
        this.egresoRepository = egresoRepository;
        this.metodoPagoRepository = metodoPagoRepository;
    }

    @Override
    public List<Egreso> findAll() {
        return egresoRepository.findAll();
    }

    @Override
    public Optional<Egreso> findById(Integer id) {
        return egresoRepository.findById(id);
    }

    @Override
    public Egreso save(Egreso egreso) {

        MetodoPago metodoPago = metodoPagoRepository.findById(
                egreso.getMetodoPago().getIdMetodo()
        ).orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));

        egreso.setMetodoPago(metodoPago);

        return egresoRepository.save(egreso);
    }

    @Override
    public Egreso update(Integer id, Egreso egreso) {

        return egresoRepository.findById(id)
                .map(existing -> {

                    existing.setMonto(egreso.getMonto());
                    existing.setDescripcion(egreso.getDescripcion());
                    existing.setFecha(egreso.getFecha());

                    MetodoPago metodoPago = metodoPagoRepository.findById(
                            egreso.getMetodoPago().getIdMetodo()
                    ).orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));

                    existing.setMetodoPago(metodoPago);

                    return egresoRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Egreso no encontrado"));
    }

    @Override
    public void delete(Integer id) {
        egresoRepository.deleteById(id);
    }
}
