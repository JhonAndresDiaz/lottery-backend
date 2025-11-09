package com.konex.lottery_backend.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad JPA para Cliente, representa la tabla "clientes"
 */
@Entity
@Table(name = "clientes")
public class ClienteJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "fecha_registro", updatable = false)
    private LocalDate fechaRegistro;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<BilleteJpaEntity> billetes = new ArrayList<>();

    public ClienteJpaEntity() {
    }

    public ClienteJpaEntity(Long id, String nombre, String email, LocalDate fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
    }

    @PrePersist
    protected void onCreate() {
        if (fechaRegistro == null) {
            fechaRegistro = LocalDate.now();
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

    public List<BilleteJpaEntity> getBilletes() {
        return billetes;
    }

    public void setBilletes(List<BilleteJpaEntity> billetes) {
        this.billetes = billetes;
    }
}
