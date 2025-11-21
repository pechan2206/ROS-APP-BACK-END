package com.example.back_end.service;

import com.example.back_end.model.MetodoPago;

import java.util.List;
import java.util.Optional;

public interface MetodoPagoService {

    List<MetodoPago> findAll();

    Optional<MetodoPago> findById(Integer id);

    MetodoPago save(MetodoPago metodoPago);

    MetodoPago update(Integer id, MetodoPago metodoPago);

    void delete(Integer id);
}
