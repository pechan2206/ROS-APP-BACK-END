package com.example.back_end.controller;

import com.example.back_end.model.Mesa;
import com.example.back_end.model.enums.EstadoMesa;
import com.example.back_end.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mesas")
@CrossOrigin(origins = "*")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    // LISTAR
    @GetMapping
    public List<Mesa> listar() {
        return mesaService.listar();
    }

    // OBTENER POR ID
    @GetMapping("/{id}")
    public Mesa obtener(@PathVariable Integer id) {
        return mesaService.obtenerPorId(id);
    }

    // CREAR
    @PostMapping
    public Mesa crear(@RequestBody Mesa mesa) {
        return mesaService.guardar(mesa);
    }

    // EDITAR
    @PutMapping("/{id}")
    public Mesa editar(@PathVariable Integer id, @RequestBody Mesa mesa) {
        return mesaService.actualizar(id, mesa);
    }

    // ACTUALIZAR ESTADO
    @PatchMapping("/{id}/estado")
    public Mesa actualizarEstado(
            @PathVariable Integer id,
            @RequestBody EstadoRequest request
    ) {
        // Convertimos el string a ENUM correctamente
        EstadoMesa estado = EstadoMesa.valueOf(request.getEstado().toUpperCase());
        return mesaService.actualizarEstado(id, estado);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        mesaService.eliminar(id);
    }

    // Clase interna para recibir el JSON { "estado": "OCUPADA" }
    public static class EstadoRequest {
        private String estado;

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
    }
}
