package com.example.back_end.controller;

import com.example.back_end.model.Caja;
import com.example.back_end.service.CajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cajas")
@CrossOrigin(origins = "*")
public class CajaController {

    @Autowired
    private CajaService cajaService;

    // 🔹 Listar todas las cajas
    @GetMapping
    public List<Caja> listar() {
        return cajaService.listar();
    }

    // 🔹 Buscar una caja por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Caja> obtenerPorId(@PathVariable Integer id) {
        Caja caja = cajaService.obtenerPorId(id);
        return ResponseEntity.ok(caja);
    }

    // 🔹 Crear una nueva caja
    @PostMapping
    public ResponseEntity<Caja> guardar(@RequestBody Caja caja) {
        Caja nuevaCaja = cajaService.guardar(caja);
        return ResponseEntity.ok(nuevaCaja);
    }

    // 🔹 Actualizar una caja completa
    @PutMapping("/{id}")
    public ResponseEntity<Caja> actualizar(@PathVariable Integer id, @RequestBody Caja cajaActualizada) {
        Caja caja = cajaService.actualizar(id, cajaActualizada);
        return ResponseEntity.ok(caja);
    }

    // 🔹 Eliminar una caja por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        cajaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // 🔹 Actualizar el saldo final de una caja
    @PutMapping("/{id}/saldo-final")
    public ResponseEntity<Caja> actualizarSaldoFinal(
            @PathVariable Integer id,
            @RequestParam Double nuevoSaldoFinal) {
        Caja caja = cajaService.actualizarSaldoFinal(id, nuevoSaldoFinal);
        return ResponseEntity.ok(caja);
    }
}
