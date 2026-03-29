package com.example.back_end.service;

import com.example.back_end.dto.VentasPorPeriodoDTO;
import com.example.back_end.dto.ProductosMasVendidosDTO;
import com.example.back_end.dto.VentasDiariasDTO;
import com.example.back_end.repository.IngresoRepository;
import com.example.back_end.repository.PlatoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteService {

    private final IngresoRepository ingresoRepository; 

    public List<VentasPorPeriodoDTO> getVentasPorPeriodo(LocalDate inicio, LocalDate fin) {
        return ingresoRepository.findVentasPorPeriodo(inicio, fin);
    }

public List<VentasDiariasDTO> getVentasDiariasDelMes() {
    return ingresoRepository.findVentasDiariasDelMes(); 
}

private final PlatoRepository platoRepository; 

public List<ProductosMasVendidosDTO> getProductosMasVendidos() {
    return platoRepository.findProductosMasVendidos();
}
    
}