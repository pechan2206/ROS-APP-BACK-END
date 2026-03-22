package com.example.back_end.service;

import com.example.back_end.dto.VentasPorPeriodoDTO;
import com.example.back_end.dto.VentasDiariasDTO;
import com.example.back_end.repository.FacturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteService {

    private final FacturaRepository facturaRepository;

    public List<VentasPorPeriodoDTO> getVentasPorPeriodo(LocalDate inicio, LocalDate fin) {
        LocalDateTime start = inicio.atStartOfDay();
        LocalDateTime end   = fin.atTime(23, 59, 59);
        return facturaRepository.findVentasPorPeriodo(start, end);
    }

    public List<VentasDiariasDTO> getVentasDiariasDelMes() {
        return facturaRepository.findVentasDiariasDelMes();
    }
}