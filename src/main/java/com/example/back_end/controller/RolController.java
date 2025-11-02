package com.example.back_end.controller;

import com.example.back_end.model.Rol;
import com.example.back_end.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen (útil para frontend)
public class RolController {

    @Autowired
    private RolService rolService;

    // ✅ Obtener todos los roles
    @GetMapping
    public ResponseEntity<List<Rol>> listar() {
        List<Rol> roles = rolService.listar();
        return ResponseEntity.ok(roles);
    }

    // ✅ Obtener un rol por ID
    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerPorId(@PathVariable Integer id) {
        Optional<Rol> rol = rolService.obtenerPorId(id);
        return rol.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Crear un nuevo rol
    @PostMapping
    public ResponseEntity<Rol> guardar(@RequestBody Rol rol) {
        Rol nuevoRol = rolService.guardar(rol);
        return ResponseEntity.ok(nuevoRol);
    }

    // ✅ Actualizar un rol existente
    @PutMapping("/{id}")
    public ResponseEntity<Rol> actualizar(@PathVariable Integer id, @RequestBody Rol rol) {
        Rol rolActualizado = rolService.actualizar(id, rol);
        if (rolActualizado != null) {
            return ResponseEntity.ok(rolActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ Eliminar un rol
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        Optional<Rol> rol = rolService.obtenerPorId(id);
        if (rol.isPresent()) {
            rolService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
