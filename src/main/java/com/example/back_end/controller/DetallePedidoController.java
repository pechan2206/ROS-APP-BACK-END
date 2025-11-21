package com.example.back_end.controller;

import com.example.back_end.model.DetallePedido;
import com.example.back_end.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalles-pedido")
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
        Optional<DetallePedido> detalle = detallePedidoService.findById(id);
        return detalle.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Guardar
    @PostMapping
    public DetallePedido save(@RequestBody DetallePedido detallePedido) {
        return detallePedidoService.save(detallePedido);
    }

    // Actualizar
    @PutMapping("/{id}")
    public DetallePedido update(@PathVariable Integer id, @RequestBody DetallePedido detallePedido) {
        return detallePedidoService.update(id, detallePedido);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        detallePedidoService.delete(id);
    }
}
