package com.example.back_end.controller;

import com.example.back_end.model.MetodoPago;
import com.example.back_end.service.implement.MetodoPagoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(origins = "*")
public class MetodosPagoController {

    @Autowired
    private MetodoPagoServiceImpl pagoService;

    // 🔹 Listar todos los pagos
    @GetMapping
    public List<MetodoPago> listar() {
        return pagoService.findAll();
    }

    // 🔹 Obtener un pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<MetodoPago>> obtenerPorId(@PathVariable Integer id) {
        Optional<MetodoPago> pago = pagoService.findById(id);
        return ResponseEntity.ok(pago);
    }

    // 🔹 Crear un nuevo pago
    @PostMapping
    public ResponseEntity<MetodoPago> guardar(@RequestBody MetodoPago pago) {
        MetodoPago nuevoPago = pagoService.save(pago);
        return ResponseEntity.ok(nuevoPago);
    }

    // 🔹 Actualizar un pago existente
    @PutMapping("/{id}")
    public ResponseEntity<MetodoPago> actualizar(@PathVariable Integer id, @RequestBody MetodoPago pagoActualizado) {
        MetodoPago pago = pagoService.update(id, pagoActualizado);
        return ResponseEntity.ok(pago);
    }

    // 🔹 Eliminar un pago por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        pagoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
