package com.example.back_end.service;

import com.example.back_end.model.Inventario;

import java.util.List;
import java.util.Optional;

public interface InventarioService {

    List<Inventario> listar();
    Optional<Inventario> obtenerPorId(Integer id);
    Inventario guardar(Inventario inventario);
    void eliminar(Integer id);
    Inventario actualizar(Integer id, Inventario inventario);
}
