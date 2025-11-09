package com.konex.lottery_backend.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad JPA para Sorteo, representa la tabla "sorteos"
 */
@Entity
@Table(name = "sorteos")
public class SorteoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDate fechaCreacion;

    @OneToMany(mappedBy = "sorteo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BilleteJpaEntity> billetes = new ArrayList<>();

    public SorteoJpaEntity() {
    }

    public SorteoJpaEntity(Long id, String nombre, LocalDate fecha, LocalDate fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.fechaCreacion = fechaCreacion;
    }

    @PrePersist
    protected void onCreate() {
        if (fechaCreacion == null) {
            fechaCreacion = LocalDate.now();
        }
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

    public List<BilleteJpaEntity> getBilletes() {
        return billetes;
    }

    public void setBilletes(List<BilleteJpaEntity> billetes) {
        this.billetes = billetes;
    }
}
