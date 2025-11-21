package com.example.back_end.service;

import com.example.back_end.model.Egreso;

import java.util.List;
import java.util.Optional;

public interface EgresoService {

    List<Egreso> findAll();

    Optional<Egreso> findById(Integer id);

    Egreso save(Egreso egreso);

    Egreso update(Integer id, Egreso egreso);

    void delete(Integer id);
}
