package com.konex.lottery_backend.infrastructure.adapter.out.persistence.entity;

import com.konex.lottery_backend.domain.model.EstadoBillete;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entidad JPA para Billete, representa la tabla "billetes"
 */
@Entity
@Table(name = "billetes",
        uniqueConstraints = @UniqueConstraint(columnNames = {"numero", "sorteo_id"}))
public class BilleteJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false, length = 20)
    private String numero;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private EstadoBillete estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sorteo_id", nullable = false)
    private SorteoJpaEntity sorteo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private ClienteJpaEntity cliente;

    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    public BilleteJpaEntity() {
    }

    public BilleteJpaEntity(Long id, String numero, BigDecimal precio, EstadoBillete estado,
                            SorteoJpaEntity sorteo, ClienteJpaEntity cliente,
                            LocalDateTime fechaVenta, LocalDateTime fechaCreacion) {
        this.id = id;
        this.numero = numero;
        this.precio = precio;
        this.estado = estado;
        this.sorteo = sorteo;
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
        this.fechaCreacion = fechaCreacion;
    }

    @PrePersist
    protected void onCreate() {
        if (fechaCreacion == null) {
            fechaCreacion = LocalDateTime.now();
        }
        if (estado == null) {
            estado = EstadoBillete.DISPONIBLE;
        }
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

    public SorteoJpaEntity getSorteo() {
        return sorteo;
    }

    public void setSorteo(SorteoJpaEntity sorteo) {
        this.sorteo = sorteo;
    }

    public ClienteJpaEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteJpaEntity cliente) {
        this.cliente = cliente;
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
