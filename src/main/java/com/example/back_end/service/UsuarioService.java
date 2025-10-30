package com.example.back_end.service;

import com.example.back_end.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> listar();
    Optional<Usuario> obtenerPorId(Integer id);
    Usuario guardar(Usuario usuario);
    void eliminar(Integer id);
    Usuario actualizar(Integer id, Usuario usuario );
}
