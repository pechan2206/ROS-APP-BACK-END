package com.example.back_end.controller;

import com.example.back_end.model.Menu;
import com.example.back_end.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
@CrossOrigin(origins = "*")
public class MenuController {

    @Autowired
    private MenuService menuService;

    // 🔹 Listar todos los menús
    @GetMapping
    public List<Menu> listar() {
        return menuService.listar();
    }

    // 🔹 Buscar un menú por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Menu> obtenerPorId(@PathVariable Integer id) {
        Menu menu = menuService.obtenerPorId(id);
        return ResponseEntity.ok(menu);
    }

    // 🔹 Crear un nuevo menú
    @PostMapping
    public ResponseEntity<Menu> guardar(@RequestBody Menu menu) {
        Menu nuevoMenu = menuService.guardar(menu);
        return ResponseEntity.ok(nuevoMenu);
    }

    // 🔹 Actualizar un menú existente
    @PutMapping("/{id}")
    public ResponseEntity<Menu> actualizar(@PathVariable Integer id, @RequestBody Menu menuActualizado) {
        Menu menu = menuService.actualizar(id, menuActualizado);
        return ResponseEntity.ok(menu);
    }

    // 🔹 Eliminar un menú
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        menuService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // 🔹 Buscar menús por precio máximo
    @GetMapping("/precio-menor")
    public List<Menu> listarPorPrecioMenor(@RequestParam Double precioMax) {
        return menuService.listarPorPrecioMenor(precioMax);
    }

    // 🔹 Buscar menús por nombre (contiene texto)
    @GetMapping("/buscar")
    public List<Menu> buscarPorNombre(@RequestParam String nombre) {
        return menuService.buscarPorNombre(nombre);
    }
}
