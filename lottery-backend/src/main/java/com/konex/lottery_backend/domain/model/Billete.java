package com.konex.lottery_backend.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entidad de Dominio: Billete
 */
public class Billete {

    private Long id;
    private String numero;
    private BigDecimal precio;
    private EstadoBillete estado;
    private Long sorteoId;
    private Long clienteId;
    private LocalDateTime fechaVenta;
    private LocalDateTime fechaCreacion;

    public Billete() {
        this.estado = EstadoBillete.DISPONIBLE;
        this.fechaCreacion = LocalDateTime.now();
    }

    // Constructor para crear billete nuevo
    public Billete(String numero, BigDecimal precio, Long sorteoId) {
        this();
        this.numero = numero;
        this.precio = precio;
        this.sorteoId = sorteoId;
    }

    public Billete(Long id, String numero, BigDecimal precio, EstadoBillete estado,
                   Long sorteoId, Long clienteId, LocalDateTime fechaVenta, LocalDateTime fechaCreacion) {
        this.id = id;
        this.numero = numero;
        this.precio = precio;
        this.estado = estado != null ? estado : EstadoBillete.DISPONIBLE;
        this.sorteoId = sorteoId;
        this.clienteId = clienteId;
        this.fechaVenta = fechaVenta;
        this.fechaCreacion = fechaCreacion != null ? fechaCreacion : LocalDateTime.now();
    }

    // ==================== LÓGICA DE NEGOCIO ====================

    /**
     * Vende el billete a un cliente
     */
    public void vender(Long clienteId) {
        if (this.estado == EstadoBillete.VENDIDO) {
            throw new IllegalStateException(
                    "No se puede vender el billete " + this.numero +
                            " porque ya ha sido vendido"
            );
        }

        Objects.requireNonNull(clienteId, "El ID del cliente no puede ser null");

        // Ejecutar la venta
        this.estado = EstadoBillete.VENDIDO;
        this.clienteId = clienteId;
        this.fechaVenta = LocalDateTime.now();
    }

    /**
     * Valida si el billete puede ser vendido
     */
    public boolean puedeVenderse() {
        return this.estado.isDisponible();
    }

    /**
     * Verifica si el billete ya fue vendido
     */
    public boolean estaVendido() {
        return this.estado.isVendido();
    }

    /**
     * Valida si el billete tiene todos los datos requeridos
     */
    public boolean isValido() {
        return numero != null && !numero.trim().isEmpty()
                && precio != null && precio.compareTo(BigDecimal.ZERO) > 0
                && sorteoId != null
                && estado != null;
    }

    /**
     * Verifica si el billete pertenece a un cliente específico
     */
    public boolean perteneceACliente(Long clienteId) {
        return this.clienteId != null && this.clienteId.equals(clienteId);
    }

    /**
     * Verifica si el billete pertenece a un sorteo específico
     */
    public boolean perteneceASorteo(Long sorteoId) {
        return this.sorteoId != null && this.sorteoId.equals(sorteoId);
    }

    // ==================== GETTERS Y SETTERS ====================

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

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
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

    // ==================== EQUALS Y HASHCODE ====================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Billete billete = (Billete) o;
        return Objects.equals(id, billete.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Billete{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", precio=" + precio +
                ", estado=" + estado +
                ", sorteoId=" + sorteoId +
                ", clienteId=" + clienteId +
                '}';
    }
}
