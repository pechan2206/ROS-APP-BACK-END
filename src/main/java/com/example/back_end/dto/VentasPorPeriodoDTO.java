package com.example.back_end.dto;

import java.time.LocalDate;

public interface VentasPorPeriodoDTO {
    LocalDate getFecha();
    Double getTotal();
    Long getCantidadFacturas();
}