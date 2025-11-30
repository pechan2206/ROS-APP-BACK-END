package com.example.back_end.seeder;

import com.example.back_end.model.Rol;
import com.example.back_end.model.Usuario;
import com.example.back_end.repository.UsuarioRepository;
import com.example.back_end.repository.RolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UsuarioSeeder {

    @Bean
    CommandLineRunner seedUsuarios(UsuarioRepository usuarioRepository,
                                   RolRepository rolRepository,
                                   PasswordEncoder passwordEncoder) {
        return args -> {
            if(usuarioRepository.count() == 0) {
                Rol adminRol = rolRepository.findByNombre("Administrador")
                        .orElseThrow(() -> new RuntimeException("Rol Administrador no encontrado"));

                Usuario admin = new Usuario(
                        null,
                        "Admin",
                        "Sistema",
                        "admin@restaurante.com",
                        "3001234567",
                        passwordEncoder.encode("12345"),
                        Usuario.EstadoUsuario.Activo, // 🔹 Ahora usamos el enum
                        null,                 // fechaRegistro se puede dejar en null, JPA lo llenará si configuras default
                        adminRol
                );

                Rol meseroRol = rolRepository.findByNombre("Mero")
                        .orElseThrow(() -> new RuntimeException("Rol Administrador no encontrado"));
                Usuario mesero = new Usuario(
                        null,
                        "Andres",
                        "Andrade",
                        "mesero@restaurante.com",
                        "3001234567",
                        passwordEncoder.encode("123456"),
                        Usuario.EstadoUsuario.Activo, // 🔹 Ahora usamos el enum
                        null,
                        meseroRol

                );


                usuarioRepository.save(mesero);
                usuarioRepository.save(admin);
            }
        };
    }


}
