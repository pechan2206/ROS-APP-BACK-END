package com.example.back_end.service;

import com.example.back_end.model.Caja;

import java.util.List;
import java.util.Optional;

public interface CajaService {

    List<Caja> listar();
    Optional<Caja> obtenerPorId(Integer id);
    Caja guardar(Caja caja);
    void eliminar(Integer id);
    Caja actualizar(Integer id, Caja caja);

}
