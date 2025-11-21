package com.example.back_end.service;

import com.example.back_end.model.MovimientoInventario;

import java.util.List;
import java.util.Optional;

public interface MovimientoInventarioService {

    List<MovimientoInventario> findAll();

    Optional<MovimientoInventario> findById(Integer id);

    MovimientoInventario save(MovimientoInventario movimiento);

    MovimientoInventario update(Integer id, MovimientoInventario movimiento);

    void delete(Integer id);
}
