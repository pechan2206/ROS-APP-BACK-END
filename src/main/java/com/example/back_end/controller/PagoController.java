package com.example.back_end.controller;

import com.example.back_end.model.Pago;
import com.example.back_end.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(origins = "*")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    // 🔹 Listar todos los pagos
    @GetMapping
    public List<Pago> listar() {
        return pagoService.listar();
    }

    // 🔹 Obtener un pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pago> obtenerPorId(@PathVariable Integer id) {
        Pago pago = pagoService.obtenerPorId(id);
        return ResponseEntity.ok(pago);
    }

    // 🔹 Crear un nuevo pago
    @PostMapping
    public ResponseEntity<Pago> guardar(@RequestBody Pago pago) {
        Pago nuevoPago = pagoService.guardar(pago);
        return ResponseEntity.ok(nuevoPago);
    }

    // 🔹 Actualizar un pago existente
    @PutMapping("/{id}")
    public ResponseEntity<Pago> actualizar(@PathVariable Integer id, @RequestBody Pago pagoActualizado) {
        Pago pago = pagoService.actualizar(id, pagoActualizado);
        return ResponseEntity.ok(pago);
    }

    // 🔹 Eliminar un pago por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        pagoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // 🔹 Listar pagos por método (efectivo, tarjeta, etc.)
    @GetMapping("/metodo/{metodo}")
    public List<Pago> listarPorMetodo(@PathVariable String metodo) {
        return pagoService.listarPorMetodo(metodo);
    }

    // 🔹 Listar pagos entre fechas
    @GetMapping("/rango-fechas")
    public List<Pago> listarPorRangoFechas(
            @RequestParam LocalDateTime desde,
            @RequestParam LocalDateTime hasta) {
        return pagoService.listarPorRangoFechas(desde, hasta);
    }

    // 🔹 Calcular el total de pagos entre fechas
    @GetMapping("/total")
    public Double totalPagosEntreFechas(
            @RequestParam LocalDateTime desde,
            @RequestParam LocalDateTime hasta) {
        return pagoService.calcularTotalPagosEntreFechas(desde, hasta);
    }
}
