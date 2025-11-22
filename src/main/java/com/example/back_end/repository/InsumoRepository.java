package com.example.back_end.repository;

import com.example.back_end.model.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InsumoRepository extends JpaRepository<Insumo, Integer> {

    Optional<Insumo> findByNombre(String nombre);
}
