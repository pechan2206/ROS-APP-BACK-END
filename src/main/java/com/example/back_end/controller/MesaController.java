package com.example.back_end.controller;

import com.example.back_end.model.Mesa;
import com.example.back_end.model.enums.EstadoMesa;
import com.example.back_end.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/mesas")
@CrossOrigin(origins = "*")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping
    public List<Mesa> listar() {
        return mesaService.listar();
    }

    @GetMapping("/{id}")
    public Mesa obtener(@PathVariable Integer id) {
        return mesaService.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Mesa mesa) {
        try {
            Mesa nueva = mesaService.guardar(mesa);
            return ResponseEntity.ok(nueva);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity
                .badRequest()
                .body(Map.of("mensaje", "Ya existe una mesa con el número " + mesa.getNumero()));
        }
    }

    @PutMapping("/{id}")
    public Mesa editar(@PathVariable Integer id, @RequestBody Mesa mesa) {
        return mesaService.actualizar(id, mesa);
    }

    @PatchMapping("/{id}/estado")
    public Mesa actualizarEstado(
            @PathVariable Integer id,
            @RequestBody EstadoRequest request
    ) {
        EstadoMesa estado = EstadoMesa.valueOf(request.getEstado().toUpperCase());
        return mesaService.actualizarEstado(id, estado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        mesaService.eliminar(id);
    }

    // ✅ ESTE ES EL QUE TE FALLABA
    @GetMapping("/numero/{numero}")
    public ResponseEntity<Mesa> obtenerPorNumero(@PathVariable Integer numero) {
        return mesaService.obtenerPorNumero(numero)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public static class EstadoRequest {
        private String estado;

        public String getEstado() { return estado; }
        public void setEstado(String estado) { this.estado = estado; }
    }
}