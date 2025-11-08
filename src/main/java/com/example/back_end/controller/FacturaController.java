package com.example.back_end.controller;

import com.example.back_end.model.Factura;
import com.example.back_end.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/facturas")
@CrossOrigin(origins = "*")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    // 🔹 Listar todas las facturas
    @GetMapping
    public List<Factura> listar() {
        return facturaService.listar();
    }

    // 🔹 Buscar factura por ID
    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerPorId(@PathVariable Integer id) {
        Factura factura = facturaService.obtenerPorId(id);
        return ResponseEntity.ok(factura);
    }

    // 🔹 Crear nueva factura
    @PostMapping
    public ResponseEntity<Factura> guardar(@RequestBody Factura factura) {
        Factura nuevaFactura = facturaService.guardar(factura);
        return ResponseEntity.ok(nuevaFactura);
    }

    // 🔹 Actualizar factura existente
    @PutMapping("/{id}")
    public ResponseEntity<Factura> actualizar(@PathVariable Integer id, @RequestBody Factura facturaActualizada) {
        Factura factura = facturaService.actualizar(id, facturaActualizada);
        return ResponseEntity.ok(factura);
    }

    // 🔹 Eliminar factura por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        facturaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // 🔹 Buscar facturas por cliente (opcional)
    @GetMapping("/cliente/{idCliente}")
    public List<Factura> buscarPorCliente(@PathVariable Integer idCliente) {
        return facturaService.buscarPorCliente(idCliente);
    }
}
