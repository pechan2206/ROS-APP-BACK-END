package com.example.back_end.repository;

import com.example.back_end.dto.VentasPorPeriodoDTO;
import com.example.back_end.dto.VentasDiariasDTO;
import com.example.back_end.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {

    // Ventas agrupadas por día dentro de un rango de fechas
    @Query("""
        SELECT new com.example.back_end.dto.VentasPorPeriodoDTO(
            CAST(f.fecha AS string),
            SUM(f.total),
            COUNT(f)
        )
        FROM Factura f
        WHERE f.fecha BETWEEN :inicio AND :fin
        GROUP BY CAST(f.fecha AS string)
        ORDER BY CAST(f.fecha AS string)
    """)
    List<VentasPorPeriodoDTO> findVentasPorPeriodo(
        @Param("inicio") LocalDateTime inicio,
        @Param("fin") LocalDateTime fin
    );

    // Ventas de los últimos 7 días (ventas diarias del mes actual)
    @Query("""
        SELECT new com.example.back_end.dto.VentasDiariasDTO(
            FUNCTION('DAYNAME', f.fecha),
            CAST(f.fecha AS string),
            SUM(f.total),
            COUNT(f)
        )
        FROM Factura f
        WHERE FUNCTION('YEAR', f.fecha)  = FUNCTION('YEAR',  CURRENT_TIMESTAMP)
          AND FUNCTION('MONTH', f.fecha) = FUNCTION('MONTH', CURRENT_TIMESTAMP)
        GROUP BY FUNCTION('DAYNAME', f.fecha), CAST(f.fecha AS string)
        ORDER BY CAST(f.fecha AS string)
    """)
    List<VentasDiariasDTO> findVentasDiariasDelMes();
}