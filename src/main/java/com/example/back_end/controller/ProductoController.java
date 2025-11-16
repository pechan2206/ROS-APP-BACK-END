package com.example.back_end.controller;

import com.example.back_end.model.Producto;
import com.example.back_end.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // 🔹 Listar todos los productos
    @GetMapping
    public List<Producto> listar() {
        return productoService.listar();
    }

    // 🔹 Buscar producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Producto>> obtenerPorId(@PathVariable Integer id) {
        Optional<Producto> producto = productoService.obtenerPorId(id);
        return ResponseEntity.ok(producto);
    }

    // 🔹 Crear nuevo producto
    @PostMapping
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.guardar(producto);
        return ResponseEntity.ok(nuevoProducto);
    }

    // 🔹 Actualizar producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Integer id, @RequestBody Producto productoActualizado) {
        Producto producto = productoService.actualizar(id, productoActualizado);
        return ResponseEntity.ok(producto);
    }

    // 🔹 Eliminar producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // 🔹 Buscar productos por nombre (opcional)
    @GetMapping("/buscar")
    public List<Producto> buscarPorNombre(@RequestParam String nombre) {
        return productoService.buscarPorNombre(nombre);
    }
}
