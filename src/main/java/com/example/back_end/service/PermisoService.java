package com.example.back_end.service;

import com.example.back_end.model.Permiso;

import java.util.List;
import java.util.Optional;

public interface PermisoService {

    List<Permiso> listar();
    Optional<Permiso> obtenerPorId(Integer id);
    Permiso guardar(Permiso permiso);
    void eliminar(Integer id);
    Permiso actualizar(Integer id, Permiso permiso);
}
