package com.example.back_end.seeder;

import com.example.back_end.model.Rol;
import com.example.back_end.model.Usuario;
import com.example.back_end.repository.UsuarioRepository;
import com.example.back_end.repository.RolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class UsuarioSeeder {

    @Bean
    @Order(2)
    CommandLineRunner seedUsuarios(UsuarioRepository usuarioRepository,
                                   RolRepository rolRepository,
                                   PasswordEncoder passwordEncoder) {
        return args -> {
            // Solo siembra usuarios si no hay ninguno.
            if(usuarioRepository.count() == 0) {

                // --- 1. ADMINISTRADOR ---
                Rol adminRol = rolRepository.findByNombre("Administrador")
                        .orElseThrow(() -> new RuntimeException("Rol Administrador no encontrado. Asegúrate de que exista en la DB."));

                Usuario admin = new Usuario(
                        null,
                        "Admin",
                        "Sistema",
                        "admin@restaurante.com",
                        "3001234567",
                        passwordEncoder.encode("12345"),
                        Usuario.EstadoUsuario.Activo,
                        null,
                        adminRol
                );
                admin.setFechaRegistro(LocalDateTime.now());

                // --- 2. MESERO ---
                Rol meseroRol = rolRepository.findByNombre("Mesero")
                        .orElseThrow(() -> new RuntimeException("Rol Mesero no encontrado. Asegúrate de que exista en la DB."));

                Usuario mesero = new Usuario(
                        null,
                        "Andres",
                        "Andrade",
                        "mesero@restaurante.com",
                        "3001234567",
                        passwordEncoder.encode("123456"),
                        Usuario.EstadoUsuario.Activo,
                        null,
                        meseroRol
                );
                mesero.setFechaRegistro(LocalDateTime.now());

                // --- 3. COCINERO ---
                Rol cocineroRol = rolRepository.findByNombre("Cocinero")
                        .orElseThrow(() -> new RuntimeException("Rol Cocinero no encontrado. Asegúrate de que exista en la DB."));

                Usuario cocinero = new Usuario(
                        null,
                        "Miguel",
                        "Rodriguez",
                        "cocinero@restaurante.com",
                        "3001234999",
                        passwordEncoder.encode("12345"),
                        Usuario.EstadoUsuario.Activo,
                        null,
                        cocineroRol
                );
                cocinero.setFechaRegistro(LocalDateTime.now());

                // --- 4. CAJERO (NUEVO) ---
                Rol cajeroRol = rolRepository.findByNombre("Cajero")
                        .orElseThrow(() -> new RuntimeException("Rol Cajero no encontrado. Asegúrate de que exista en la DB."));

                Usuario cajero = new Usuario(
                        null,
                        "Laura",
                        "Martinez",
                        "cajero@restaurante.com",
                        "3009876543",
                        passwordEncoder.encode("12345"),
                        Usuario.EstadoUsuario.Activo,
                        null,
                        cajeroRol
                );
                cajero.setFechaRegistro(LocalDateTime.now());

                // --- Guardar todos los usuarios ---
                usuarioRepository.saveAll(List.of(admin, mesero, cocinero, cajero));
            }
        };
    }
}