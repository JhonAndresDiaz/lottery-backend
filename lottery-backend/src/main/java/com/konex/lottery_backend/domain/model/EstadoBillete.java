package com.konex.lottery_backend.domain.model;

/**
 * Estados posibles de un billete
 */
public enum EstadoBillete {

    DISPONIBLE,
    VENDIDO;

    /**
     * Verifica si el billete está disponible para venta
     */
    public boolean isDisponible() {
        return this == DISPONIBLE;
    }

    /**
     * Verifica si el billete ya fue vendido
     */
    public boolean isVendido() {
        return this == VENDIDO;
    }
}
