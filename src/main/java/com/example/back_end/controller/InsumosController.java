package com.example.back_end.controller;

import com.example.back_end.model.Insumo;
import com.example.back_end.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/insumos")
public class InsumosController {

    private final InsumoService insumoService;

    @Autowired
    public InsumosController(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    @GetMapping
    public List<Insumo> findAll() {
        return insumoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Insumo> findById(@PathVariable Integer id) {
        return insumoService.findById(id);
    }

    @PostMapping
    public Insumo save(@RequestBody Insumo insumo) {
        return insumoService.save(insumo);
    }

    @PutMapping("/{id}")
    public Insumo update(@PathVariable Integer id, @RequestBody Insumo insumo) {
        return insumoService.update(id, insumo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        insumoService.delete(id);
    }
}
