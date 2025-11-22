package com.example.back_end.repository;

import com.example.back_end.model.Plato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlatoRepository extends JpaRepository<Plato, Integer> {

    Optional<Plato> findByNombre(String nombre);
}
