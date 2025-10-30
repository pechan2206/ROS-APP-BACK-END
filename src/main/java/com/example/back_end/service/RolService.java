package com.example.back_end.service;

import com.example.back_end.model.Rol;

import java.util.List;
import java.util.Optional;

public interface RolService {

    List<Rol> listar();
    Optional<Rol> obtenerPorId(Integer id);
    Rol guardar(Rol rol);
    void eliminar(Integer id);
    Rol actualizar(Integer id, Rol rol);
}
