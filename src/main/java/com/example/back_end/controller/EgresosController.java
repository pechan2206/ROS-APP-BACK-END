package com.example.back_end.controller;

import com.example.back_end.model.Egreso;
import com.example.back_end.service.EgresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/egresos")
public class EgresosController {

    private final EgresoService egresoService;

    @Autowired
    public EgresosController(EgresoService egresoService) {
        this.egresoService = egresoService;
    }

    @GetMapping
    public List<Egreso> findAll() {
        return egresoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Egreso> findById(@PathVariable Integer id) {
        return egresoService.findById(id);
    }

    @PostMapping
    public Egreso save(@RequestBody Egreso egreso) {
        return egresoService.save(egreso);
    }

    @PutMapping("/{id}")
    public Egreso update(@PathVariable Integer id, @RequestBody Egreso egreso) {
        return egresoService.update(id, egreso);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        egresoService.delete(id);
    }
}
