package com.example.back_end.service;

import com.example.back_end.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> listar();
    Optional<Cliente> obtenerPorId(Integer id);
    Cliente guardar(Cliente cliente);
    void eliminar(Integer id);
    Cliente actualizar(Integer id, Cliente cliente);

    // 🔹 Agregar este método
    List<Cliente> buscarPorNombre(String nombre);
}
