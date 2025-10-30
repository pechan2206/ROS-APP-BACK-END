package com.example.back_end.service;

import com.example.back_end.model.ProveedorProducto;

import java.util.List;
import java.util.Optional;

public interface ProveedorProductoService {

    List<ProveedorProducto> listar();
    Optional<ProveedorProducto> obtenerPorId(Integer id);
    ProveedorProducto guardar(ProveedorProducto proveedorProducto);
    void eliminar(Integer id);
    ProveedorProducto actualizar(Integer id, ProveedorProducto proveedorProducto);
}
