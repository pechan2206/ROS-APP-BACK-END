package com.example.back_end.controller;


import com.example.back_end.model.Usuario;
import com.example.back_end.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar(){
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> buscarPorId(@PathVariable Integer id){
        return usuarioService.obtenerPorId(id);
    }

    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario){

        return usuarioService.guardar(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        return usuarioService.actualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        usuarioService.eliminar(id);
    }


}
