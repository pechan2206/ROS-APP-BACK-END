package com.example.back_end.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentasPorPeriodoDTO {
    private LocalDate fecha;     // ← cambia String por LocalDate
    private Double total;
    private Long cantidadFacturas;
}