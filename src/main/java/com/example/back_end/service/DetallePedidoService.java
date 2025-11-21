package com.example.back_end.service;

import com.example.back_end.model.DetallePedido;

import java.util.List;
import java.util.Optional;

public interface DetallePedidoService {

    List<DetallePedido> findAll();

    Optional<DetallePedido> findById(Integer id);

    DetallePedido save(DetallePedido detallePedido);

    DetallePedido update(Integer id, DetallePedido detallePedido);

    void delete(Integer id);
}
