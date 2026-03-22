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

    @Query(value = """
        SELECT 
            DATE(fecha) AS fecha,
            SUM(total) AS total,
            COUNT(*) AS cantidadFacturas
        FROM facturas
        WHERE fecha BETWEEN :inicio AND :fin
        GROUP BY DATE(fecha)
        ORDER BY DATE(fecha)
    """, nativeQuery = true)
    List<VentasPorPeriodoDTO> findVentasPorPeriodo(
        @Param("inicio") LocalDateTime inicio,
        @Param("fin") LocalDateTime fin
    );

    @Query(value = """
        SELECT 
            DAYNAME(fecha) AS dia,
            DATE(fecha) AS fecha,
            SUM(total) AS total,
            COUNT(*) AS cantidadFacturas
        FROM facturas
        WHERE YEAR(fecha) = YEAR(NOW())
          AND MONTH(fecha) = MONTH(NOW())
        GROUP BY DAYNAME(fecha), DATE(fecha)
        ORDER BY DATE(fecha)
    """, nativeQuery = true)
    List<VentasDiariasDTO> findVentasDiariasDelMes();
}