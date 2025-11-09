package com.konex.lottery_backend.infrastructure.adapter.in.rest.dto.request;

import jakarta.validation.constraints.NotNull;

/**
 * DTO Request para vender un billete
 */
public class VentaBilleteRequest {

    @NotNull(message = "El ID del billete es obligatorio")
    private Long billeteId;

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long clienteId;

    public VentaBilleteRequest() {
    }

    public VentaBilleteRequest(Long billeteId, Long clienteId) {
        this.billeteId = billeteId;
        this.clienteId = clienteId;
    }

    // Getters y Setters

    public Long getBilleteId() {
        return billeteId;
    }

    public void setBilleteId(Long billeteId) {
        this.billeteId = billeteId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
