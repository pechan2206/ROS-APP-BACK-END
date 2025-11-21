package com.example.back_end.service;

import com.example.back_end.model.CategoriaPlato;

import java.util.List;
import java.util.Optional;

public interface CategoriaPlatoService {

    List<CategoriaPlato> findAll();

    Optional<CategoriaPlato> findById(Integer id);

    CategoriaPlato save(CategoriaPlato categoriaPlato);

    CategoriaPlato update(Integer id, CategoriaPlato categoriaPlato);

    void delete(Integer id);
}
