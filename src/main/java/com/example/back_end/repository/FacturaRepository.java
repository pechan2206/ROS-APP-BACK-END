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

    @Query("""
        SELECT new com.example.back_end.dto.VentasPorPeriodoDTO(
            CAST(f.fecha AS date),
            SUM(f.total),
            COUNT(f)
        )
        FROM Factura f
        WHERE f.fecha BETWEEN :inicio AND :fin
        GROUP BY CAST(f.fecha AS date)
        ORDER BY CAST(f.fecha AS date)
    """)
    List<VentasPorPeriodoDTO> findVentasPorPeriodo(
        @Param("inicio") LocalDateTime inicio,
        @Param("fin") LocalDateTime fin
    );

    @Query("""
        SELECT new com.example.back_end.dto.VentasDiariasDTO(
            FUNCTION('DAYNAME', f.fecha),
            CAST(f.fecha AS date),
            SUM(f.total),
            COUNT(f)
        )
        FROM Factura f
        WHERE FUNCTION('YEAR', f.fecha)  = FUNCTION('YEAR',  CURRENT_TIMESTAMP)
          AND FUNCTION('MONTH', f.fecha) = FUNCTION('MONTH', CURRENT_TIMESTAMP)
        GROUP BY FUNCTION('DAYNAME', f.fecha), CAST(f.fecha AS date)
        ORDER BY CAST(f.fecha AS date)
    """)
    List<VentasDiariasDTO> findVentasDiariasDelMes();
}