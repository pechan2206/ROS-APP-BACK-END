package com.example.back_end.service.implement;

import com.example.back_end.model.Mesa;
import com.example.back_end.model.enums.EstadoMesa;
import com.example.back_end.repository.MesaRepository;
import com.example.back_end.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaServiceImpl implements MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    @Override
    public List<Mesa> listar() {
        return mesaRepository.findAll();
    }

    @Override
    public Mesa obtenerPorId(Integer id) {
        return mesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada con ID: " + id));
    }

    @Override
    public Mesa guardar(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    @Override
    public void eliminar(Integer id) {
        mesaRepository.deleteById(id);
    }

    @Override
    public Mesa actualizar(Integer id, Mesa mesaActualizada) {
        Mesa mesaExistente = obtenerPorId(id);
        mesaExistente.setEstado(mesaActualizada.getEstado());

        return mesaRepository.save(mesaExistente);
    }

    @Override
    public Mesa actualizarEstado(Integer id, EstadoMesa nuevoEstado) {
        Mesa mesa = obtenerPorId(id);
        mesa.setEstado(nuevoEstado);
        return mesaRepository.save(mesa);
    }

    @Override
    public List<Mesa> listarPorEstado(EstadoMesa estado) {
        return mesaRepository.findByEstado(estado);
    }
}
