package com.example.back_end.seeder;

import com.example.back_end.model.Rol;
import com.example.back_end.model.Usuario;
import com.example.back_end.repository.UsuarioRepository;
import com.example.back_end.repository.RolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List; // Importar List para usar saveAll

@Configuration
public class UsuarioSeeder {

    @Bean
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

                // --- 2. MESERO ---
                // ✅ CORRECCIÓN: Usamos "Mesero" en lugar de "Mero" y la excepción correcta
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

                // --- 3. COCINERO (Nuevo Rol) ---
                Rol cocineroRol = rolRepository.findByNombre("Cocinero")
                        // ✅ Mensaje de excepción específico
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
                        cocineroRol // Asignamos el rol de Cocinero
                );

                // --- Guardar todos los usuarios ---
                // Utilizando saveAll es más eficiente.
                usuarioRepository.saveAll(List.of(admin, mesero, cocinero));
            }
        };
    }
}