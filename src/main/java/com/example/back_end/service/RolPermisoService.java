package com.example.back_end.service;

import com.example.back_end.model.RolPermiso;

import java.util.List;
import java.util.Optional;

public interface RolPermisoService {

    List<RolPermiso> listar();
    Optional<RolPermiso> obtenerPorId(Integer id);
    RolPermiso guardar(RolPermiso rolPermiso);
    void eliminar(Integer id);
    RolPermiso actualizar(Integer id, RolPermiso rolPermiso);
}
