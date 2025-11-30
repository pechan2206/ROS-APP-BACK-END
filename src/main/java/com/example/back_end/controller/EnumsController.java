package com.example.back_end.controller;


import com.example.back_end.model.enums.EstadoPedido;
import com.example.back_end.model.enums.TipoPedido;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enums")
@CrossOrigin(origins = "*")
public class EnumsController {

    @GetMapping("/estado-pedido")
    public EstadoPedido[] listarEstados(){
        return EstadoPedido
                .values();
    }

    @GetMapping("/tipo-pedido")
    public TipoPedido[] listarTipos(){
        return TipoPedido
                .values();
    }

}
