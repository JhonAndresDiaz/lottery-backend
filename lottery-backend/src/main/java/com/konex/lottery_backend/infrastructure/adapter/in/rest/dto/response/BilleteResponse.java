package com.konex.lottery_backend.infrastructure.adapter.in.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.konex.lottery_backend.domain.model.EstadoBillete;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO Response para Billete
 */
public class BilleteResponse {

    private Long id;
    private String numero;
    private BigDecimal precio;
    private EstadoBillete estado;

    private Long sorteoId;
    private String sorteoNombre;

    private Long clienteId;
    private String clienteNombre;
    private String clienteEmail;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaVenta;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaCreacion;

    public BilleteResponse() {
    }

    public BilleteResponse(Long id, String numero, BigDecimal precio, EstadoBillete estado,
                           Long sorteoId, String sorteoNombre, Long clienteId, String clienteNombre,
                           String clienteEmail, LocalDateTime fechaVenta, LocalDateTime fechaCreacion) {
        this.id = id;
        this.numero = numero;
        this.precio = precio;
        this.estado = estado;
        this.sorteoId = sorteoId;
        this.sorteoNombre = sorteoNombre;
        this.clienteId = clienteId;
        this.clienteNombre = clienteNombre;
        this.clienteEmail = clienteEmail;
        this.fechaVenta = fechaVenta;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public EstadoBillete getEstado() {
        return estado;
    }

    public void setEstado(EstadoBillete estado) {
        this.estado = estado;
    }

    public Long getSorteoId() {
        return sorteoId;
    }

    public void setSorteoId(Long sorteoId) {
        this.sorteoId = sorteoId;
    }

    public String getSorteoNombre() {
        return sorteoNombre;
    }

    public void setSorteoNombre(String sorteoNombre) {
        this.sorteoNombre = sorteoNombre;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}