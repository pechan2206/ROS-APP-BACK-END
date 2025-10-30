package com.example.back_end.service;

import com.example.back_end.model.CajaDomicilio;

import java.util.List;
import java.util.Optional;

public interface CajaDomicilioService {

    List<CajaDomicilio> listar();
    Optional<CajaDomicilio> obtenerPorId(Integer id);
    CajaDomicilio guardar(CajaDomicilio cajaDomicilio);
    void eliminar(Integer id);
    CajaDomicilio actualizar(Integer id, CajaDomicilio cajaDomicilio);

}

