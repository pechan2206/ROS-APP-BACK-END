package com.example.back_end.service;

import com.example.back_end.model.RolUsuario;

import java.util.List;
import java.util.Optional;

public interface RolUsuarioService {

    List<RolUsuario> listar();
    Optional<RolUsuario> obtenerPorId(Integer id);
    RolUsuario guardar(RolUsuario rolUsuario);
    void eliminar(Integer id);
    RolUsuario actualizar(Integer id, RolUsuario rolUsuario);
}
