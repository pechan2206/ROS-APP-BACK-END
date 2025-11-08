package com.example.back_end.controller;

import com.example.back_end.model.Domicilio;
import com.example.back_end.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/domicilios")
@CrossOrigin(origins = "*")
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService;

    // 🔹 Listar todos los domicilios
    @GetMapping
    public List<Domicilio> listar() {
        return domicilioService.listar();
    }

    // 🔹 Buscar domicilio por ID
    @GetMapping("/{id}")
    public ResponseEntity<Domicilio> obtenerPorId(@PathVariable Integer id) {
        Domicilio domicilio = domicilioService.obtenerPorId(id);
        return ResponseEntity.ok(domicilio);
    }

    // 🔹 Crear nuevo domicilio
    @PostMapping
    public ResponseEntity<Domicilio> guardar(@RequestBody Domicilio domicilio) {
        Domicilio nuevoDomicilio = domicilioService.guardar(domicilio);
        return ResponseEntity.ok(nuevoDomicilio);
    }

    // 🔹 Actualizar domicilio existente
    @PutMapping("/{id}")
    public ResponseEntity<Domicilio> actualizar(@PathVariable Integer id, @RequestBody Domicilio domicilioActualizado) {
        Domicilio domicilio = domicilioService.actualizar(id, domicilioActualizado);
        return ResponseEntity.ok(domicilio);
    }

    // 🔹 Eliminar domicilio por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        domicilioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // 🔹 Buscar por teléfono de contacto
    @GetMapping("/buscar")
    public List<Domicilio> buscarPorTelefono(@RequestParam String telefono) {
        return domicilioService.buscarPorTelefono(telefono);
    }
}
