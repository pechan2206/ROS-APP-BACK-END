package com.example.back_end.repository;

import com.example.back_end.model.CategoriaPlato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaPlatoRepository extends JpaRepository<CategoriaPlato, Integer> {

    Optional<CategoriaPlato> findByNombre(String nombre);
}
