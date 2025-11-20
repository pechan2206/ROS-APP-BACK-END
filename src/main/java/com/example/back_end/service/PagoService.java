package com.example.back_end.service;

import com.example.back_end.model.Pago;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PagoService {

    List<Pago> listar();
    Optional<Pago> obtenerPorId(Integer id);
    Pago guardar(Pago pago);
    void eliminar(Integer id);
    Pago actualizar(Integer id, Pago pago);
    List<Pago> listarPorMetodo(String metodo);
    List<Pago> listarPorRangoFechas(LocalDateTime desde, LocalDateTime hasta);
    Double calcularTotalPagosEntreFechas(LocalDateTime desde, LocalDateTime hasta);
}
