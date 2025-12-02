package com.example.back_end.controller;

import com.example.back_end.model.Ingreso;
import com.example.back_end.repository.IngresoRepository;
import com.example.back_end.repository.PedidoRepository;
import com.example.back_end.service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/report")
@CrossOrigin(origins = "*")
public class ReportController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/reporte-por-pedido")
    public List<Map<String, Object>> getPedidosPorTipo() {
        return pedidoRepository.contarPorTipo();
    }




}
