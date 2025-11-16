package com.example.back_end.service;

import com.example.back_end.model.Pedido;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PedidoService {

    List<Pedido> listar();
    Optional<Pedido> obtenerPorId(Integer id);
    Pedido guardar(Pedido pedido);
    void eliminar(Integer id);
    Pedido actualizar(Integer id, Pedido pedido);
    List<Pedido> listarPorMesa(Integer idMesa);
    List<Pedido> listarPorRangoFechas(Date desde, Date hasta);
}
