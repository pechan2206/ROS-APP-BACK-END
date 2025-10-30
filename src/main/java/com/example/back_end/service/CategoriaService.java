package com.example.back_end.service;

import com.example.back_end.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<Categoria> listar();
    Optional<Categoria> obtenerPorId(Integer id);
    Categoria guardar(Categoria categoria);
    void eliminar(Integer id);
    Categoria actualizar(Integer id, Categoria categoria);

}
