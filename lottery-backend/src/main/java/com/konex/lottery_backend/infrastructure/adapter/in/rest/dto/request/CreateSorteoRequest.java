package com.konex.lottery_backend.infrastructure.adapter.in.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/**
 * DTO Request para crear un sorteo
 *
 * Este DTO es recibido por el controller REST cuando el frontend
 * envía una petición POST para crear un sorteo.
 */
public class CreateSorteoRequest {

    @NotBlank(message = "El nombre del sorteo es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    @NotNull(message = "La fecha del sorteo es obligatoria")
    private LocalDate fecha;


    public CreateSorteoRequest() {
    }

    public CreateSorteoRequest(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}

