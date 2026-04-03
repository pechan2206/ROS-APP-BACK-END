package com.example.back_end.controller;

import com.example.back_end.dto.ProductosMasVendidosDTO;
import com.example.back_end.dto.VentasDiariasDTO;
import com.example.back_end.dto.VentasPorPeriodoDTO;
import com.example.back_end.repository.IngresoRepository;  // 👈 NUEVO
import com.example.back_end.repository.PedidoRepository;
import com.example.back_end.service.ReporteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/report")
@CrossOrigin(origins = "*")
public class ReportController {

    private final ReporteService reporteService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private IngresoRepository ingresoRepository;  // 👈 NUEVO

    public ReportController(ReporteService reporteService) {
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

    @GetMapping("/reporte-por-pedido")
    public List<Map<String, Object>> getPedidosPorTipo() {
        return pedidoRepository.contarPorTipo();
    }

    @GetMapping("/productos-mas-vendidos")
    public ResponseEntity<List<ProductosMasVendidosDTO>> productosMasVendidos() {
        return ResponseEntity.ok(reporteService.getProductosMasVendidos());
    }

@GetMapping("/ingresos-por-metodo-pago")
public List<Map<String, Object>> ingresosPorMetodoPago(
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {
    return ingresoRepository.ingresosPorMetodoPago(inicio, fin);
}
}