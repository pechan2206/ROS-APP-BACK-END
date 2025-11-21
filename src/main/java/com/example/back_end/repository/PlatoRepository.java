package com.example.back_end.repository;

import com.example.back_end.model.Plato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatoRepository extends JpaRepository<Plato, Integer> {
}
