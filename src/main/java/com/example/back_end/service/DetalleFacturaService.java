package com.example.back_end.service;

import com.example.back_end.model.DetalleFactura;

import java.util.List;
import java.util.Optional;

public interface DetalleFacturaService {

    List<DetalleFactura> listar();
    Optional<DetalleFactura> obtenerPorId(Integer id);
    DetalleFactura guardar(DetalleFactura detalleFactura);
    void eliminar(Integer id);
    DetalleFactura actualizar(Integer id, DetalleFactura detalleFactura);
}
