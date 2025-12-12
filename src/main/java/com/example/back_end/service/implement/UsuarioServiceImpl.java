package com.example.back_end.service.implement;

import com.example.back_end.model.Usuario;
import com.example.back_end.repository.UsuarioRepository;
import com.example.back_end.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerPorId(Integer id){
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario guardar(Usuario usuario){
        String passwordHash = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(passwordHash);
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(Integer id){
        usuarioRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public Usuario actualizar(Integer id, Usuario datos) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));


        usuarioExistente.setEstado(datos.getEstado());
        usuarioExistente.setNombre(datos.getNombre());
        usuarioExistente.setApellido(datos.getApellido());
        usuarioExistente.setTelefono(datos.getTelefono());
        usuarioExistente.setRol(datos.getRol());
        usuarioExistente.setCorreo(datos.getCorreo());

        return usuarioRepository.save(usuarioExistente);
    }

}
