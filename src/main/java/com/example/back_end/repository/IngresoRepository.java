package com.example.back_end.repository;

import com.example.back_end.dto.VentasPorPeriodoDTO;
import com.example.back_end.model.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IngresoRepository extends JpaRepository<Ingreso, Integer> {

    @Query("""
        SELECT
            i.fecha                  AS fecha,
            SUM(i.monto)             AS total,
            COUNT(i.idIngreso)       AS cantidadFacturas
        FROM Ingreso i
        WHERE i.fecha BETWEEN :inicio AND :fin
        GROUP BY i.fecha
        ORDER BY i.fecha ASC
    """)
    List<VentasPorPeriodoDTO> findVentasPorPeriodo(
        @Param("inicio") LocalDate inicio,
        @Param("fin")    LocalDate fin
    );
}