package com.example.back_end.controller;

import com.example.back_end.model.Promocion;
import com.example.back_end.service.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/promociones")
@CrossOrigin(origins = "*")
public class PromocionController {

    @Autowired
    private PromocionService promocionService;

    @GetMapping
    public List<Promocion> listar(){
        return promocionService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Promocion> buscarPorId(@PathVariable Integer id){
        return promocionService.obtenerPorId(id);
    }

    @PostMapping
    public Promocion guardar(@RequestBody Promocion promocion){
        return promocionService.guardar(promocion);
    }

    @PutMapping("/{id}")
    public Promocion actualizar(@PathVariable Integer id, @RequestBody Promocion promocion) {
        return promocionService.actualizar(id, promocion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        promocionService.eliminar(id);
    }
}
