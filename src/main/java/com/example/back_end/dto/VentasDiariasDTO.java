package com.example.back_end.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentasDiariasDTO {
    private String dia;          
    private LocalDate fecha;    
    private Double total;
    private Long cantidadFacturas;
}