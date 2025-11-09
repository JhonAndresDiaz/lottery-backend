package com.konex.lottery_backend.infrastructure.adapter.in.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

/**
 * DTO Response para Sorteo
 */
public class SorteoResponse {

    private Long id;
    private String nombre;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaCreacion;

    private Integer totalBilletes;
    private Integer billetesDisponibles;
    private Integer billetesVendidos;


    public SorteoResponse() {
    }

    public SorteoResponse(Long id, String nombre, LocalDate fecha, LocalDate fechaCreacion,
                          Integer totalBilletes, Integer billetesDisponibles, Integer billetesVendidos) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.fechaCreacion = fechaCreacion;
        this.totalBilletes = totalBilletes;
        this.billetesDisponibles = billetesDisponibles;
        this.billetesVendidos = billetesVendidos;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getTotalBilletes() {
        return totalBilletes;
    }

    public void setTotalBilletes(Integer totalBilletes) {
        this.totalBilletes = totalBilletes;
    }

    public Integer getBilletesDisponibles() {
        return billetesDisponibles;
    }

    public void setBilletesDisponibles(Integer billetesDisponibles) {
        this.billetesDisponibles = billetesDisponibles;
    }

    public Integer getBilletesVendidos() {
        return billetesVendidos;
    }

    public void setBilletesVendidos(Integer billetesVendidos) {
        this.billetesVendidos = billetesVendidos;
    }
}
