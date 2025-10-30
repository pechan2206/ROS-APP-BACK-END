package com.example.back_end.service;

import com.example.back_end.model.Promocion;

import java.util.List;
import java.util.Optional;

public interface PromocionService {

    List<Promocion> listar();
    Optional<Promocion> obtenerPorId(Integer id);
    Promocion guardar(Promocion promocion);
    void eliminar(Integer id);
    Promocion actualizar(Integer id, Promocion promocion);
}
