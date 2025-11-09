package com.konex.lottery_backend.infrastructure.adapter.in.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

/**
 * DTO Response para Cliente
 */
public class ClienteResponse {

    private Long id;
    private String nombre;
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    private Integer totalBilletesComprados;

    public ClienteResponse() {
    }

    public ClienteResponse(Long id, String nombre, String email, LocalDate fechaRegistro,
                           Integer totalBilletesComprados) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.totalBilletesComprados = totalBilletesComprados;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getTotalBilletesComprados() {
        return totalBilletesComprados;
    }

    public void setTotalBilletesComprados(Integer totalBilletesComprados) {
        this.totalBilletesComprados = totalBilletesComprados;
    }
}
