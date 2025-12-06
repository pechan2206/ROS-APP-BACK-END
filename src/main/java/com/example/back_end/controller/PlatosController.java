package com.example.back_end.controller;

import com.example.back_end.model.Plato;
import com.example.back_end.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/platos")
@CrossOrigin(origins = "*")
public class PlatosController {

    @Autowired
    private PlatoService platoService;

    @GetMapping
    public List<Plato> listar(){
        return platoService.findAll();
    }

}
