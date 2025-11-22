package com.example.back_end.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Desactivar CSRF para pruebas locales
                .csrf(csrf -> csrf.disable())

                // Configuración de acceso
                .authorizeHttpRequests(auth -> auth
                        // 🔹 Permitir Swagger UI y docs JSON
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html"
                        ).permitAll()

                        // 🔹 Todo lo demás libre (puedes cambiar a authenticated() luego)
                        .anyRequest().permitAll()
                )

                // Desactivar login básico
                .httpBasic(httpBasic -> httpBasic.disable());

        return http.build();
    }
}
