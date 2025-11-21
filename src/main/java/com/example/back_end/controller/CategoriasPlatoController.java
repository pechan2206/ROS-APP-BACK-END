package com.example.back_end.controller;

import com.example.back_end.model.CategoriaPlato;
import com.example.back_end.service.CategoriaPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias-plato")
public class CategoriasPlatoController {

    private final CategoriaPlatoService categoriaPlatoService;

    @Autowired
    public CategoriasPlatoController(CategoriaPlatoService categoriaPlatoService) {
        this.categoriaPlatoService = categoriaPlatoService;
    }

    @GetMapping
    public List<CategoriaPlato> findAll() {
        return categoriaPlatoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaPlato> findById(@PathVariable Integer id) {
        Optional<CategoriaPlato> categoria = categoriaPlatoService.findById(id);
        return categoria.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategoriaPlato save(@RequestBody CategoriaPlato categoriaPlato) {
        return categoriaPlatoService.save(categoriaPlato);
    }

    @PutMapping("/{id}")
    public CategoriaPlato update(@PathVariable Integer id, @RequestBody CategoriaPlato categoriaPlato) {
        return categoriaPlatoService.update(id, categoriaPlato);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        categoriaPlatoService.delete(id);
    }
}
