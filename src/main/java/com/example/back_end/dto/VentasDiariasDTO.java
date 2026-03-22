package com.example.back_end.dto;

import java.time.LocalDate;

public interface VentasDiariasDTO {
    String getDia();
    LocalDate getFecha();
    Double getTotal();
    Long getCantidadFacturas();
}