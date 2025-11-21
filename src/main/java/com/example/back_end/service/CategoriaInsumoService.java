package com.example.back_end.service;

import com.example.back_end.model.CategoriaInsumo;

import java.util.List;
import java.util.Optional;

public interface CategoriaInsumoService {

    List<CategoriaInsumo> findAll();

    Optional<CategoriaInsumo> findById(Integer id);

    CategoriaInsumo save(CategoriaInsumo categoriaInsumo);

    CategoriaInsumo update(Integer id, CategoriaInsumo categoriaInsumo);

    void delete(Integer id);
}
