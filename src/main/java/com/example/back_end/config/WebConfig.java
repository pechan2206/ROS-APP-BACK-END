package com.example.back_end.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configura CORS para permitir solicitudes desde cualquier origen (puedes ajustarlo según sea necesario)
        registry.addMapping("/api/email/**")
                .allowedOrigins("*")  // Puedes especificar dominios aquí si lo prefieres
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
