package com.example.back_end.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentasDiariasDTO {
    private String dia;         // "Lunes", "Martes"...
    private String fecha;       // "2025-03-17"
    private Double total;
    private Long cantidadFacturas;
}