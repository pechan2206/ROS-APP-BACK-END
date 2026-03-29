package com.example.back_end.service;

import com.example.back_end.dto.VentasPorPeriodoDTO;
import com.example.back_end.dto.VentasDiariasDTO;
import com.example.back_end.repository.IngresoRepository;
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
    
}