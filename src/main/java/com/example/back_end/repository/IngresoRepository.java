package com.example.back_end.repository;

import com.example.back_end.model.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngresoRepository extends JpaRepository<Ingreso, Integer> {
}
