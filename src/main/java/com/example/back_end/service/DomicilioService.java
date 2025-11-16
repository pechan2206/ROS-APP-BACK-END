package com.example.back_end.service;

import com.example.back_end.model.Domicilio;

import java.util.List;
import java.util.Optional;

public interface DomicilioService {

    List<Domicilio> listar();
    Optional<Domicilio> obtenerPorId(Integer id);
    Domicilio guardar(Domicilio domicilio);
    void eliminar(Integer id);
    Domicilio actualizar(Integer id, Domicilio domicilio);
    List<Domicilio> buscarPorTelefono(String telefono);
}
