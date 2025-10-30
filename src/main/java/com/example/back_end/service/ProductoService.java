package com.example.back_end.service;

import com.example.back_end.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> listar();
    Optional<Producto> obtenerPorId(Integer id);
    Producto guardar(Producto producto);
    void eliminar(Integer id);
    Producto actualizar(Integer id, Producto producto);
}
