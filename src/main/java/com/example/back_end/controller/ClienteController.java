package com.example.back_end.controller;

import com.example.back_end.model.Cliente;
import com.example.back_end.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // 🔹 Listar todos los clientes
    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    // 🔹 Buscar cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerPorId(@PathVariable Integer id) {
        Cliente cliente = clienteService.obtenerPorId(id);
        return ResponseEntity.ok(cliente);
    }

    // 🔹 Crear nuevo cliente
    @PostMapping
    public ResponseEntity<Cliente> guardar(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.guardar(cliente);
        return ResponseEntity.ok(nuevoCliente);
    }

    // 🔹 Actualizar cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Integer id, @RequestBody Cliente clienteActualizado) {
        Cliente cliente = clienteService.actualizar(id, clienteActualizado);
        return ResponseEntity.ok(cliente);
    }

    // 🔹 Eliminar cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        clienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // 🔹 Buscar clientes por nombre (opcional)
    @GetMapping("/buscar")
    public List<Cliente> buscarPorNombre(@RequestParam String nombre) {
        return clienteService.buscarPorNombre(nombre);
    }
}
