package com.example.back_end.service.implement;

import com.example.back_end.model.Insumo;
import com.example.back_end.model.MovimientoInventario;
import com.example.back_end.repository.InsumoRepository;
import com.example.back_end.repository.MovimientoInventarioRepository;
import com.example.back_end.service.MovimientoInventarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoInventarioServiceImpl implements MovimientoInventarioService {

    private final MovimientoInventarioRepository movimientoInventarioRepository;
    private final InsumoRepository insumoRepository;

    public MovimientoInventarioServiceImpl(MovimientoInventarioRepository movimientoInventarioRepository,
                                           InsumoRepository insumoRepository) {
        this.movimientoInventarioRepository = movimientoInventarioRepository;
        this.insumoRepository = insumoRepository;
    }

    @Override
    public List<MovimientoInventario> findAll() {
        return movimientoInventarioRepository.findAll();
    }

    @Override
    public Optional<MovimientoInventario> findById(Integer id) {
        return movimientoInventarioRepository.findById(id);
    }

    @Override
    public MovimientoInventario save(MovimientoInventario movimiento) {

        Insumo insumo = insumoRepository.findById(
                movimiento.getInsumo().getIdInsumo()
        ).orElseThrow(() -> new RuntimeException("Insumo no encontrado"));

        movimiento.setInsumo(insumo);

        return movimientoInventarioRepository.save(movimiento);
    }

    @Override
    public MovimientoInventario update(Integer id, MovimientoInventario movimiento) {

        return movimientoInventarioRepository.findById(id)
                .map(existing -> {

                    existing.setTipo(movimiento.getTipo());
                    existing.setCantidad(movimiento.getCantidad());
                    existing.setFecha(movimiento.getFecha());
                    existing.setDescripcion(movimiento.getDescripcion());

                    if (movimiento.getInsumo() != null) {
                        Insumo insumo = insumoRepository.findById(
                                movimiento.getInsumo().getIdInsumo()
                        ).orElseThrow(() -> new RuntimeException("Insumo no encontrado"));

                        existing.setInsumo(insumo);
                    }

                    return movimientoInventarioRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Movimiento de inventario no encontrado"));
    }

    @Override
    public void delete(Integer id) {
        movimientoInventarioRepository.deleteById(id);
    }
}
