package com.example.back_end.controller;

import com.example.back_end.model.DetalleFactura;
import com.example.back_end.service.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detallefacturas")
@CrossOrigin(origins = "*")
public class DetalleFacturaController {

    @Autowired
    private DetalleFacturaService detalleFacturaService;

    @GetMapping
    public List<DetalleFactura> listar(){
        return detalleFacturaService.listar();
    }

    @GetMapping("/{id}")
    public Optional<DetalleFactura> buscarPorId(@PathVariable Integer id){
        return detalleFacturaService.obtenerPorId(id);
    }

    @PostMapping
    public DetalleFactura guardar(@RequestBody DetalleFactura detalleFactura){
        return detalleFacturaService.guardar(detalleFactura);
    }

    @PutMapping("/{id}")
    public DetalleFactura actualizar(@PathVariable Integer id, @RequestBody DetalleFactura detalleFactura) {
        return detalleFacturaService.actualizar(id, detalleFactura);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        detalleFacturaService.eliminar(id);
    }
}
