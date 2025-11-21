package com.example.back_end.service;

import com.example.back_end.model.Insumo;

import java.util.List;
import java.util.Optional;

public interface InsumoService {

    List<Insumo> findAll();

    Optional<Insumo> findById(Integer id);

    Insumo save(Insumo insumo);

    Insumo update(Integer id, Insumo insumo);

    void delete(Integer id);
}
