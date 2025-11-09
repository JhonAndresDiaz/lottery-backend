package com.konex.lottery_backend.infrastructure.adapter.in.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

/**
 * DTO Request para crear un billete
 */
public class CreateBilleteRequest {

    @NotBlank(message = "El número del billete es obligatorio")
    @Size(min = 1, max = 20, message = "El número debe tener entre 1 y 20 caracteres")
    private String numero;

    @NotNull(message = "El precio del billete es obligatorio")
    @Positive(message = "El precio debe ser mayor a cero")
    private BigDecimal precio;

    @NotNull(message = "El ID del sorteo es obligatorio")
    private Long sorteoId;

    public CreateBilleteRequest() {
    }

    public CreateBilleteRequest(String numero, BigDecimal precio, Long sorteoId) {
        this.numero = numero;
        this.precio = precio;
        this.sorteoId = sorteoId;
    }

    // Getters y Setters

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

    public Long getSorteoId() {
        return sorteoId;
    }

    public void setSorteoId(Long sorteoId) {
        this.sorteoId = sorteoId;
    }
}
