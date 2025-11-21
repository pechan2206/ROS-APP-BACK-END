package com.example.back_end.service;

import com.example.back_end.model.Ingreso;

import java.util.List;
import java.util.Optional;

public interface IngresoService {

    List<Ingreso> findAll();

    Optional<Ingreso> findById(Integer id);

    Ingreso save(Ingreso ingreso);

    Ingreso update(Integer id, Ingreso ingreso);

    void delete(Integer id);
}
