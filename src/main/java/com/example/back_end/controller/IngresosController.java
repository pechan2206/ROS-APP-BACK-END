package com.example.back_end.controller;

import com.example.back_end.model.Ingreso;
import com.example.back_end.service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public Ingreso save(@RequestBody Ingreso ingreso) {
        return ingresoService.save(ingreso);
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
