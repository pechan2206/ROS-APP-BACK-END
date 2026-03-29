package com.example.back_end.service.implement;

import com.example.back_end.model.Usuario;
import com.example.back_end.repository.UsuarioRepository;
import com.example.back_end.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario actualizar(Integer id, Usuario usuario) {

        Usuario existente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Validar correo duplicado (excepto el mismo usuario)
        if (usuarioRepository.existsByCorreoAndIdUsuarioNot(usuario.getCorreo(), id)) {
            throw new RuntimeException("El correo ya está en uso por otro usuario");
        }

        // 🔥 Actualizar campos sobre el existente
        existente.setNombre(usuario.getNombre());
        existente.setApellido(usuario.getApellido());
        existente.setCorreo(usuario.getCorreo());
        existente.setTelefono(usuario.getTelefono());
        existente.setContrasena(usuario.getContrasena());
        existente.setRol(usuario.getRol());



        return usuarioRepository.save(existente);
    }
}
