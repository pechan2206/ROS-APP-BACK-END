package com.example.back_end.service;

import com.example.back_end.model.Factura;

import java.util.List;
import java.util.Optional;

public interface FacturaService {

    List<Factura> listar();
    Optional<Factura> obtenerPorId(Integer id);
    Factura guardar(Factura factura);
    void eliminar(Integer id);
    Factura actualizar(Integer id, Factura factura);
}
