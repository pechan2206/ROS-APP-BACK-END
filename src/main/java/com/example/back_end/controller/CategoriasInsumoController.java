package com.example.back_end.controller;

import com.example.back_end.model.CategoriaInsumo;
import com.example.back_end.service.CategoriaInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias-insumo")
public class CategoriasInsumoController {

    private final CategoriaInsumoService categoriaInsumoService;

    @Autowired
    public CategoriasInsumoController(CategoriaInsumoService categoriaInsumoService) {
        this.categoriaInsumoService = categoriaInsumoService;
    }

    @GetMapping
    public List<CategoriaInsumo> findAll() {
        return categoriaInsumoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaInsumo> findById(@PathVariable Integer id) {
        Optional<CategoriaInsumo> categoria = categoriaInsumoService.findById(id);
        return categoria.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategoriaInsumo save(@RequestBody CategoriaInsumo categoriaInsumo) {
        return categoriaInsumoService.save(categoriaInsumo);
    }

    @PutMapping("/{id}")
    public CategoriaInsumo update(@PathVariable Integer id, @RequestBody CategoriaInsumo categoriaInsumo) {
        return categoriaInsumoService.update(id, categoriaInsumo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        categoriaInsumoService.delete(id);
    }
}
