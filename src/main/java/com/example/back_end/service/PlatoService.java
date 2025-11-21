package com.example.back_end.service;

import com.example.back_end.model.Plato;

import java.util.List;
import java.util.Optional;

public interface PlatoService {

    List<Plato> findAll();

    Optional<Plato> findById(Integer id);

    Plato save(Plato plato);

    Plato update(Integer id, Plato plato);

    void delete(Integer id);
}
