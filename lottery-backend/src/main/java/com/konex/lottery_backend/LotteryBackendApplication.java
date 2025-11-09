package com.konex.lottery_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Arquitectura: Hexagonal
 * Base de Datos: H2
 */
@SpringBootApplication
public class LotteryBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LotteryBackendApplication.class, args);

		System.out.println("\n" +
			"\n" +
			"Backend iniciado \n" +
			"\n" +
			"API REST:      http://localhost:8080/api/docs  \n" +
			"H2 Console:    http://localhost:8080/h2-console  \n" +
			" \n" +
			"Arquitectura: Hexagonal (Ports & Adapters) \n"+
			"Framework: Spring Boot \n" +
			"Base de Datos: H2");
	}
}
