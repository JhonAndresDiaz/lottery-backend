package com.konex.lottery_backend.domain.port.out;

import com.konex.lottery_backend.domain.model.Sorteo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SorteoRepositoryPort {

    /**
     * Guarda un sorteo
     */
    Sorteo save(Sorteo sorteo);

    /**
     * Busca un sorteo por su ID
     */
    Optional<Sorteo> findById(Long id);

    /**
     * Obtiene todos los sorteos ordenados por fecha descendente
     */
    List<Sorteo> findAll();

    /**
     * Busca sorteos por fecha específica
     */
    List<Sorteo> findByFecha(LocalDate fecha);

    /**
     * Busca sorteos cuya fecha sea mayor o igual a la fecha dada
     */
    List<Sorteo> findByFechaGreaterThanEqual(LocalDate fecha);

    /**
     * Busca sorteos por nombre
     */
    List<Sorteo> findByNombreContaining(String nombre);

    /**
     * Elimina un sorteo por su ID
     */
    void deleteById(Long id);

    /**
     * Verifica si existe un sorteo con el ID dado
     */
    boolean existsById(Long id);

    /**
     * Cuenta el total de sorteos en el sistema
     */
    long count();
}