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
                .orElse(null);
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
    public Mesa actualizar(Integer id, Mesa mesa) {
        Mesa m = obtenerPorId(id);
        if (m == null) return null;

        m.setNumero(mesa.getNumero());
        m.setCapacidad(mesa.getCapacidad());
        m.setEstado(mesa.getEstado());

        return mesaRepository.save(m);
    }

    @Override
    public Mesa actualizarEstado(Integer id, EstadoMesa nuevoEstado) {
        Mesa mesa = obtenerPorId(id);
        if (mesa == null) return null;

        mesa.setEstado(nuevoEstado);
        return mesaRepository.save(mesa);
    }

    @Override
    public List<Mesa> listarPorEstado(EstadoMesa estado) {
        return mesaRepository.findByEstado(estado);
    }
}
