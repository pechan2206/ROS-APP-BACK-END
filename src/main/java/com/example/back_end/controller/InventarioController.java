package com.example.back_end.controller;

import com.example.back_end.model.Inventario;
import com.example.back_end.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventarios")
@CrossOrigin(origins = "*")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public List<Inventario> listar(){
        return inventarioService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Inventario> buscarPorId(@PathVariable Integer id){
        return inventarioService.obtenerPorId(id);
    }

    @PostMapping
    public Inventario guardar(@RequestBody Inventario inventario){
        return inventarioService.guardar(inventario);
    }

    @PutMapping("/{id}")
    public Inventario actualizar(@PathVariable Integer id, @RequestBody Inventario inventario) {
        return inventarioService.actualizar(id, inventario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        inventarioService.eliminar(id);
    }
}
