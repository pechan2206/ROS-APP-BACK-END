package com.example.back_end.service;

import com.example.back_end.model.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuService {

    List<Menu> listar();
    Optional<Menu> obtenerPorId(Integer id);
    Menu guardar(Menu menu);
    void eliminar(Integer id);
    Menu actualizar(Integer id, Menu menu);
}
