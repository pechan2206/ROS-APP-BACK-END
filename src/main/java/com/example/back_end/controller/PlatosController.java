package com.example.back_end.controller;

import com.example.back_end.model.Plato;
import com.example.back_end.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;

import java.util.List;

@RestController
@RequestMapping("/api/platos")
@CrossOrigin(origins = "*")
public class PlatosController {

    @Autowired
    private PlatoService platoService;

    @GetMapping
    public List<Plato> listar() {
        return platoService.findAll();
    }

    @GetMapping("/listar-activos")
    public List<Plato> listar() {
        return platoService.findAll()
                .stream()
                .filter(p -> Boolean.TRUE.equals(p.getEstado()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Plato> crear(@RequestBody Plato plato) {
        return ResponseEntity.ok(platoService.save(plato));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plato> actualizar(@PathVariable Integer id, @RequestBody Plato plato) {
        return ResponseEntity.ok(platoService.update(id, plato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        platoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}