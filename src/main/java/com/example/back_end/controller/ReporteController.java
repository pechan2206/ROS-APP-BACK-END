package com.example.back_end.controller;

import org.springframework.web.bind.annotation.*;

import com.example.back_end.dto.VentasDiariasDTO;
import com.example.back_end.dto.VentasPorPeriodoDTO;
import com.example.back_end.service.ReporteService;

import org.springframework.http.ResponseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping("/ventas-por-periodo")
    public ResponseEntity<List<VentasPorPeriodoDTO>> ventasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {

        return ResponseEntity.ok(reporteService.getVentasPorPeriodo(inicio, fin));
    }

    @GetMapping("/ventas-diarias")
    public ResponseEntity<List<VentasDiariasDTO>> ventasDiarias() {
        return ResponseEntity.ok(reporteService.getVentasDiariasDelMes());
    }
}