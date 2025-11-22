package com.example.back_end.repository;

import com.example.back_end.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor,Integer> {

    Optional<Proveedor> findByNombre(String nombre);
}
