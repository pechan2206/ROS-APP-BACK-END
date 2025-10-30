package com.example.back_end.service;

import com.example.back_end.model.Proveedor;

import java.util.List;
import java.util.Optional;

public interface ProveedorService {

    List<Proveedor> listar();
    Optional<Proveedor> obtenerPorId(Integer id);
    Proveedor guardar(Proveedor proveedor);
    void eliminar(Integer id);
    Proveedor actualizar(Integer id, Proveedor proveedor);
}
