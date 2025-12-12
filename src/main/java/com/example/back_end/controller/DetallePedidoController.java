package com.example.back_end.controller;

import com.example.back_end.model.DetallePedido;
import com.example.back_end.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalles-pedido")
@CrossOrigin(origins = "*")
public class DetallePedidoController {

    private final DetallePedidoService detallePedidoService;

    @Autowired
    public DetallePedidoController(DetallePedidoService detallePedidoService) {
        this.detallePedidoService = detallePedidoService;
    }

    // Obtener todos
    @GetMapping
    public List<DetallePedido> findAll() {
        return detallePedidoService.findAll();
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> findById(@PathVariable Integer id) {
        return detallePedidoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }




    // Crear detalle
    @PostMapping
    public ResponseEntity<?> save(@RequestBody DetallePedido detallePedido) {
        try {
            DetallePedido saved = detallePedidoService.save(detallePedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // Actualizar detalle
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody DetallePedido detallePedido) {
        try {
            DetallePedido updated = detallePedidoService.update(id, detallePedido);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            detallePedidoService.delete(id);
            return ResponseEntity.ok("Detalle eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // Obtener detalles por pedido
    @GetMapping("/pedido/{id}")
    public ResponseEntity<List<DetallePedido>> getDetallesPorPedido(@PathVariable Integer id) {
        return ResponseEntity.ok(detallePedidoService.obtenerDetallesPorPedidoId(id));
    }
}
