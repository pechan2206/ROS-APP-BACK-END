package com.example.back_end.dto;

public interface ProductosMasVendidosDTO {
    Integer getIdPlato();
    String  getNombre();
    Long    getCantidadVendida();
    Double  getTotalGenerado();
}