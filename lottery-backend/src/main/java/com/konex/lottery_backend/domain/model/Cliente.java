package com.konex.lottery_backend.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Entidad de Dominio: Cliente
 */
public class Cliente {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );

    private Long id;
    private String nombre;
    private String email;
    private LocalDate fechaRegistro;
    private List<Billete> billetes;

    public Cliente() {
        this.billetes = new ArrayList<>();
        this.fechaRegistro = LocalDate.now();
    }

    public Cliente(Long id, String nombre, String email, LocalDate fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaRegistro = fechaRegistro != null ? fechaRegistro : LocalDate.now();
        this.billetes = new ArrayList<>();
    }

    // ==================== LÓGICA DE NEGOCIO ====================

    /**
     * Agrega un billete comprado por el cliente
     */
    public void agregarBillete(Billete billete) {
        Objects.requireNonNull(billete, "El billete no puede ser null");

        if (!this.billetes.contains(billete)) {
            this.billetes.add(billete);
        }
    }

    /**
     * Obtiene el total de billetes comprados por el cliente
     */
    public int getTotalBilletesComprados() {
        return this.billetes.size();
    }

    /**
     * Valida si el email tiene un formato correcto
     */
    public boolean tieneEmailValido() {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Valida si el cliente tiene todos los datos requeridos
     */
    public boolean isValido() {
        return nombre != null && !nombre.trim().isEmpty()
                && tieneEmailValido();
    }

    /**
     * Verifica si el cliente ha realizado compras
     */
    public boolean tieneCompras() {
        return !this.billetes.isEmpty();
    }

    // ==================== GETTERS Y SETTERS ====================

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

    /**
     * Retorna una copia inmutable de la lista de billetes
     */
    public List<Billete> getBilletes() {
        return Collections.unmodifiableList(billetes);
    }

    /**
     * Establece la lista completa de billetes
     */
    public void setBilletes(List<Billete> billetes) {
        this.billetes = billetes != null ? new ArrayList<>(billetes) : new ArrayList<>();
    }

    // ==================== EQUALS Y HASHCODE ====================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", totalBilletes=" + getTotalBilletesComprados() +
                '}';
    }
}