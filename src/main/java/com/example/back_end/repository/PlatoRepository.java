package com.example.back_end.repository;

import com.example.back_end.dto.ProductosMasVendidosDTO;
import com.example.back_end.model.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlatoRepository extends JpaRepository<Plato, Integer> {

    Optional<Plato> findByNombre(String nombre);

    List<Plato> findAllByEstadoIsNullOrEstadoTrue();

    @Query("""
        SELECT
            p.idPlato          AS idPlato,
            p.nombre           AS nombre,
            SUM(d.cantidad)    AS cantidadVendida,
            SUM(d.subtotal)    AS totalGenerado
        FROM DetallePedido d
        JOIN d.plato p
        GROUP BY p.idPlato, p.nombre
        ORDER BY cantidadVendida DESC
    """)
    List<ProductosMasVendidosDTO> findProductosMasVendidos();
}