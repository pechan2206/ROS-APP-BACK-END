package com.example.back_end.repository;

import com.example.back_end.model.CategoriaInsumo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaInsumoRepository extends JpaRepository<CategoriaInsumo, Integer> {

    Optional<CategoriaInsumo> findByNombre(String nombre);
}
