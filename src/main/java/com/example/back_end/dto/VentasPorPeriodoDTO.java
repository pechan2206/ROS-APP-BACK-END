package com.example.back_end.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentasPorPeriodoDTO {
    private String fecha;       // "2025-03-01"
    private Double total;
    private Long cantidadFacturas;
}