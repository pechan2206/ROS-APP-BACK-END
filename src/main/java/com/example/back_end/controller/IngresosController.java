package com.example.back_end.controller;

import com.example.back_end.model.Ingreso;
import com.example.back_end.service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ingresos")
public class IngresosController {

    private final IngresoService ingresoService;

    @Autowired
    public IngresosController(IngresoService ingresoService) {
        this.ingresoService = ingresoService;
    }

    @GetMapping
    public List<Ingreso> findAll() {
        return ingresoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Ingreso> findById(@PathVariable Integer id) {
        return ingresoService.findById(id);
    }

    // 👇 CAMBIADO: ahora retorna ResponseEntity para poder devolver 409 en caso de duplicado
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Ingreso ingreso) {
        try {
            Ingreso nuevo = ingresoService.save(ingreso);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{id}")
    public Ingreso update(@PathVariable Integer id, @RequestBody Ingreso ingreso) {
        return ingresoService.update(id, ingreso);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        ingresoService.delete(id);
    }
}