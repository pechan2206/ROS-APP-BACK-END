package com.example.back_end.service;

import com.example.back_end.model.CajaPedido;

import java.util.List;
import java.util.Optional;

public interface CajaPedidoService {

    List<CajaPedido> listar();
    Optional<CajaPedido> obtenerPorId(Integer id);
    CajaPedido guardar(CajaPedido cajaPedido);
    void eliminar(Integer id);
    CajaPedido actualizar(Integer id, CajaPedido cajaPedido);

}
