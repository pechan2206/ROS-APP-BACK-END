package com.example.back_end.service;

import com.example.back_end.model.MenuCategoria;

import java.util.List;
import java.util.Optional;

public interface MenuCategoriaService {

    List<MenuCategoria> listar();
    Optional<MenuCategoria> obtenerPorId(Integer id);
    MenuCategoria guardar(MenuCategoria menuCategoria);
    void eliminar(Integer id);
    MenuCategoria actualizar(Integer id, MenuCategoria menuCategoria);
}
