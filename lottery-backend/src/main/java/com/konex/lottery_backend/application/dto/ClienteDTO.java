package com.konex.lottery_backend.application.dto;

import java.time.LocalDate;

/**
 * Se usa para transferir datos de clientes entre la capa de aplicación
 * y la capa de infraestructura
 */
public class ClienteDTO {

    private Long id;
    private String nombre;
    private String email;
    private LocalDate fechaRegistro;

    private Integer totalBilletesComprados;

    public ClienteDTO() {
    }

    public ClienteDTO(Long id, String nombre, String email, LocalDate fechaRegistro,
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