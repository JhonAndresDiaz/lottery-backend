package com.konex.lottery_backend.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configuración SIMPLIFICADA de OpenAPI (Swagger).
 *
 * Swagger UI: http://localhost:8080/api/docs
 * OpenAPI JSON: http://localhost:8080/api/v3/api-docs
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI lotteryOpenAPI() {
        Server localServer = new Server();
        localServer.setUrl("http://localhost:8080");
        localServer.setDescription("Servidor local");

        Contact contact = new Contact();
        contact.setName("Konex Innovation");
        contact.setEmail("desarrollo@konex.com");

        Info info = new Info()
                .title("API Sistema de Lotería")
                .version("1.0.0")
                .description("API REST para venta de billetes de lotería")
                .contact(contact);

        return new OpenAPI()
                .info(info)
                .servers(List.of(localServer));
    }
}