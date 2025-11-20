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
    public List<Caja> listar() {
        return cajaRepository.findAll();
    }

    @Override
    public Optional<Caja> obtenerPorId(Integer id) {
        return cajaRepository.findById(id);
    }

    @Override
    public Caja guardar(Caja caja) {
        return cajaRepository.save(caja);
    }

    @Override
    public void eliminar(Integer id) {
        cajaRepository.deleteById(id);
    }

    @Override
    public Caja actualizar(Integer id, Caja cajaActualizada) {
        return cajaRepository.findById(id)
                .map(caja -> {
                    caja.setNombreCaja(cajaActualizada.getNombreCaja());
                    caja.setSaldoInicial(cajaActualizada.getSaldoInicial());
                    caja.setSaldoFinal(cajaActualizada.getSaldoFinal());
                    caja.setPedidos(cajaActualizada.getPedidos());
                    caja.setDomicilios(cajaActualizada.getDomicilios());
                    return cajaRepository.save(caja);
                })
                .orElseThrow(() -> new RuntimeException("Caja no encontrada con ID: " + id));
    }

    @Override
    public Caja actualizarSaldoFinal(Integer id, Double nuevoSaldoFinal) {
        return cajaRepository.findById(id)
                .map(caja -> {
                    caja.setSaldoFinal(nuevoSaldoFinal);
                    return cajaRepository.save(caja);
                })
                .orElseThrow(() -> new RuntimeException("Caja no encontrada con ID: " + id));
    }
}
