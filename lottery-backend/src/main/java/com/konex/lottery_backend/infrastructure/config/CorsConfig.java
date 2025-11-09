package com.konex.lottery_backend.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * Configuración de CORS
 * Permite que el frontend Angular (localhost:4200) pueda hacer
 * peticiones al backend (localhost:8080)
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Permitir credenciales
        config.setAllowCredentials(true);

        // Permitir orígenes del frontend Angular
        config.setAllowedOrigins(Arrays.asList(
                "http://localhost:4200",
                "http://localhost:4201"
        ));

        // Permitir todos los headers
        config.addAllowedHeader("*");

        // Permitir todos los métodos HTTP
        config.setAllowedMethods(Arrays.asList(
                "GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"
        ));

        // Aplicar configuración a todos los endpoints
        source.registerCorsConfiguration("/api/**", config);

        return new CorsFilter(source);
    }
}