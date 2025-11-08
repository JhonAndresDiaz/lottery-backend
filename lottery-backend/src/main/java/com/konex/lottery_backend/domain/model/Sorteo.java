package com.konex.lottery_backend.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Entidad de Dominio: Sorteo
 */
public class Sorteo {

    private Long id;
    private String nombre;
    private LocalDate fecha;
    private LocalDate fechaCreacion;
    private List<Billete> billetes;

    public Sorteo() {
        this.billetes = new ArrayList<>();
        this.fechaCreacion = LocalDate.now();
    }

    // Constructor completo
    public Sorteo(Long id, String nombre, LocalDate fecha, LocalDate fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.fechaCreacion = fechaCreacion != null ? fechaCreacion : LocalDate.now();
        this.billetes = new ArrayList<>();
    }

    // ==================== LÓGICA DE NEGOCIO ====================

    /**
     * Agrega un billete al sorteo manteniendo la relación bidireccional
     */
    public void agregarBillete(Billete billete) {
        Objects.requireNonNull(billete, "El billete no puede ser null");

        if (!this.billetes.contains(billete)) {
            this.billetes.add(billete);
        }
    }

    /**
     * Remueve un billete del sorteo
     */
    public void removerBillete(Billete billete) {
        if (billete != null) {
            this.billetes.remove(billete);
        }
    }

    /**
     * Calcula el total de billetes en el sorteo
     */
    public int getTotalBilletes() {
        return this.billetes.size();
    }

    /**
     * Calcula cuántos billetes están disponibles para venta
     */
    public int getBilletesDisponibles() {
        return (int) this.billetes.stream()
                .filter(b -> b.getEstado().isDisponible())
                .count();
    }

    /**
     * Calcula cuántos billetes ya fueron vendidos
     */
    public int getBilletesVendidos() {
        return (int) this.billetes.stream()
                .filter(b -> b.getEstado().isVendido())
                .count();
    }

    /**
     * Valida si el sorteo es válido para ser creado
     */
    public boolean isValido() {
        return nombre != null && !nombre.trim().isEmpty()
                && fecha != null
                && fecha.isAfter(LocalDate.now().minusDays(1));
    }

    /**
     * Verifica si el sorteo ya ocurrió
     */
    public boolean yaOcurrio() {
        return fecha != null && fecha.isBefore(LocalDate.now());
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
        Sorteo sorteo = (Sorteo) o;
        return Objects.equals(id, sorteo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Sorteo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", totalBilletes=" + getTotalBilletes() +
                '}';
    }
}