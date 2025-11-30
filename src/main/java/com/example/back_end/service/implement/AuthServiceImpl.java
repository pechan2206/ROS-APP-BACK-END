package com.example.back_end.service.implement;

import com.example.back_end.dto.LoginRequest;
import com.example.back_end.dto.LoginResponse;
import com.example.back_end.dto.RegisterRequest;
import com.example.back_end.model.Usuario;
import com.example.back_end.repository.UsuarioRepository;
import com.example.back_end.service.AuthService;
import com.example.back_end.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String register(RegisterRequest request) {

        if (usuarioRepository.existsByCorreo(request.getCorreo())) {
            throw new RuntimeException("El correo ya está registrado");
        }

        Usuario user = new Usuario();
        user.setNombre(request.getNombre());
        user.setApellido(request.getApellido());
        user.setCorreo(request.getCorreo());
        user.setContrasena(passwordEncoder.encode(request.getContrasena()));
        user.setTelefono(request.getTelefono());
        user.setFechaRegistro(LocalDateTime.now());
        user.setRol(request.getRol()); // si el DTO trae el rol, ajusta aquí

        usuarioRepository.save(user);

        return "Usuario registrado correctamente";
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        Usuario user = usuarioRepository.findByCorreo(request.getCorreo())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(request.getContrasena(), user.getContrasena())) {
            throw new RuntimeException("Credenciales incorrectas");
        }

        // Se genera token usando el correo
        String token = jwtUtil.generateToken(user.getCorreo());

        return new LoginResponse(token, user.getRol().getNombre());
    }
}
