package com.example.back_end.repository;

import com.example.back_end.model.Egreso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EgresoRepository extends JpaRepository<Egreso, Integer> {
}
