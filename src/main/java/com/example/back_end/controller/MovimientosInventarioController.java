package com.example.back_end.controller;

import com.example.back_end.model.MovimientoInventario;
import com.example.back_end.service.MovimientoInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimientos-inventario")
public class MovimientosInventarioController {

    private final MovimientoInventarioService movimientoInventarioService;

    @Autowired
    public MovimientosInventarioController(MovimientoInventarioService movimientoInventarioService) {
        this.movimientoInventarioService = movimientoInventarioService;
    }

    @GetMapping
    public List<MovimientoInventario> findAll() {
        return movimientoInventarioService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<MovimientoInventario> findById(@PathVariable Integer id) {
        return movimientoInventarioService.findById(id);
    }

    @PostMapping
    public MovimientoInventario save(@RequestBody MovimientoInventario movimiento) {
        return movimientoInventarioService.save(movimiento);
    }

    @PutMapping("/{id}")
    public MovimientoInventario update(@PathVariable Integer id, @RequestBody MovimientoInventario movimiento) {
        return movimientoInventarioService.update(id, movimiento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        movimientoInventarioService.delete(id);
    }
}
