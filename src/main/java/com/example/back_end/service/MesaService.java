package com.example.back_end.service;

import com.example.back_end.model.Mesa;
import com.example.back_end.model.enums.EstadoMesa;

import java.util.List;
import java.util.Optional;

public interface MesaService {

    List<Mesa> listar();
    Mesa obtenerPorId(Integer id);
    Mesa guardar(Mesa mesa);
    void eliminar(Integer id);
    Mesa actualizar(Integer id, Mesa mesa);

    Mesa actualizarEstado(Integer id, EstadoMesa nuevoEstado);
    List<Mesa> listarPorEstado(EstadoMesa estado);
}
