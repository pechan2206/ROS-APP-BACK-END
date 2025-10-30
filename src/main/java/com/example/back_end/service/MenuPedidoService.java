package com.example.back_end.service;

import com.example.back_end.model.MenuPedido;

import java.util.List;
import java.util.Optional;

public interface MenuPedidoService {

    List<MenuPedido> listar();
    Optional<MenuPedido> obtenerPorId(Integer id);
    MenuPedido guardar(MenuPedido menuPedido);
    void eliminar(Integer id);
    MenuPedido actualizar(Integer id, MenuPedido menuPedido);
}
