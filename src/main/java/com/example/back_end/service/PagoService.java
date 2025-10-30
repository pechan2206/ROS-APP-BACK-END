package com.example.back_end.service;

import com.example.back_end.model.Pago;

import java.util.List;
import java.util.Optional;

public interface PagoService {

    List<Pago> listar();
    Optional<Pago> obtenerPorId(Integer id);
    Pago guardar(Pago pago);
    void eliminar(Integer id);
    Pago actualizar(Integer id, Pago pago);
}
