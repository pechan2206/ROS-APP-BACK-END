package com.example.back_end.service;

import com.example.back_end.dto.VentasPorPeriodoDTO;
import com.example.back_end.dto.VentasDiariasDTO;
import com.example.back_end.repository.FacturaRepository;
import com.example.back_end.repository.IngresoRepository; // ← agregar
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteService {

    private final FacturaRepository facturaRepository;
    private final IngresoRepository ingresoRepository; // ← agregar

    public List<VentasPorPeriodoDTO> getVentasPorPeriodo(LocalDate inicio, LocalDate fin) {
        // Ahora usa ingresos en lugar de facturas
        return ingresoRepository.findVentasPorPeriodo(inicio, fin);
    }

    public List<VentasDiariasDTO> getVentasDiariasDelMes() {
        return facturaRepository.findVentasDiariasDelMes();
    }
}