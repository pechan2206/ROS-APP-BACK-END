package com.example.back_end.controller;

import com.example.back_end.model.Pedido;
import com.example.back_end.model.enums.EstadoPedido;
import com.example.back_end.model.enums.TipoPedido;
import com.example.back_end.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // 🔹 Listar todos los pedidos
    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.listar();
    }

    // 🔹 Buscar pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pedido>> obtenerPorId(@PathVariable Integer id) {
        Optional<Pedido> pedido = pedidoService.obtenerPorId(id);
        return ResponseEntity.ok(pedido);
    }

        // ── Crear un nuevo pedido
        @PostMapping
        public ResponseEntity<?> guardar(@RequestBody Pedido pedido) {
            try {
                Pedido nuevo = pedidoService.guardar(pedido);
                return ResponseEntity.ok(nuevo);
            } catch (IllegalArgumentException e) {
                return ResponseEntity
                    .badRequest()
                    .body(Map.of("mensaje", e.getMessage()));
            }
        }

    // 🔹 Actualizar un pedido
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizar(@PathVariable Integer id, @RequestBody Pedido pedidoActualizado) {
        Pedido pedido = pedidoService.actualizar(id, pedidoActualizado);
        return ResponseEntity.ok(pedido);
    }

    // 🔹 Eliminar un pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        pedidoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // 🔹 Listar pedidos por mesa
    @GetMapping("/mesa/{idMesa}")
    public List<Pedido> listarPorMesa(@PathVariable Integer idMesa) {
        return pedidoService.listarPorMesa(idMesa);
    }

    // 🔹 Listar pedidos por rango de fechas
    @GetMapping("/fecha")
    public List<Pedido> listarPorRangoFechas(@RequestParam Date desde, @RequestParam Date hasta) {
        return pedidoService.listarPorRangoFechas(desde, hasta);
    }

}
