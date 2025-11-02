package com.example.back_end.controller;

import com.example.back_end.model.Mesa;
import com.example.back_end.model.enums.EstadoMesa;
import com.example.back_end.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mesas")
@CrossOrigin(origins = "*")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    // 🔹 Listar todas las mesas
    @GetMapping
    public List<Mesa> listar() {
        return mesaService.listar();
    }

    // 🔹 Buscar una mesa por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Mesa> obtenerPorId(@PathVariable Integer id) {
        Mesa mesa = mesaService.obtenerPorId(id);
        return ResponseEntity.ok(mesa);
    }

    // 🔹 Crear una nueva mesa
    @PostMapping
    public ResponseEntity<Mesa> guardar(@RequestBody Mesa mesa) {
        Mesa nuevaMesa = mesaService.guardar(mesa);
        return ResponseEntity.ok(nuevaMesa);
    }

    // 🔹 Actualizar una mesa completa
    @PutMapping("/{id}")
    public ResponseEntity<Mesa> actualizar(@PathVariable Integer id, @RequestBody Mesa mesaActualizada) {
        Mesa mesa = mesaService.actualizar(id, mesaActualizada);
        return ResponseEntity.ok(mesa);
    }

    // 🔹 Eliminar una mesa por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        mesaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // 🔹 Listar mesas por estado (DISPONIBLE, OCUPADA, RESERVADA)
    @GetMapping("/estado/{estado}")
    public List<Mesa> listarPorEstado(@PathVariable EstadoMesa estado) {
        return mesaService.listarPorEstado(estado);
    }

    // 🔹 Cambiar el estado de una mesa
    @PutMapping("/{id}/estado")
    public ResponseEntity<Mesa> actualizarEstado(@PathVariable Integer id, @RequestParam EstadoMesa nuevoEstado) {
        Mesa mesa = mesaService.actualizarEstado(id, nuevoEstado);
        return ResponseEntity.ok(mesa);
    }
}
