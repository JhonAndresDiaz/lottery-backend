package com.konex.lottery_backend.domain.port.out;

import com.konex.lottery_backend.domain.model.Billete;
import com.konex.lottery_backend.domain.model.EstadoBillete;

import java.util.List;
import java.util.Optional;

/**
 * - CRUD básico de billetes
 * - Búsqueda por sorteo y estado (DISPONIBLE/VENDIDO)
 * - Búsqueda por cliente (historial de compras)
 * - Verificación de número único por sorteo
 */
public interface BilleteRepositoryPort {

    /**
     * Guarda un billete
     */
    Billete save(Billete billete);

    /**
     * Busca un billete por su ID
     */
    Optional<Billete> findById(Long id);

    /**
     * Obtiene todos los billetes del sistema
     */
    List<Billete> findAll();

    /**
     * Busca todos los billetes de un sorteo específico
     */
    List<Billete> findBySorteoId(Long sorteoId);

    /**
     * Busca billetes por estado específico
     */
    List<Billete> findByEstado(EstadoBillete estado);

    /**
     * Busca billetes de un sorteo con un estado específico
     */
    List<Billete> findBySorteoIdAndEstado(Long sorteoId, EstadoBillete estado);

    /**
     * Busca todos los billetes comprados por un cliente
     */
    List<Billete> findByClienteId(Long clienteId);

    /**
     * Busca un billete por su número dentro de un sorteo específico
     */
    Optional<Billete> findByNumeroAndSorteoId(String numero, Long sorteoId);

    /**
     * Verifica si existe un billete con el número dado en un sorteo
     */
    boolean existsByNumeroAndSorteoId(String numero, Long sorteoId);

    /**
     * Cuenta billetes por estado en un sorteo específico
     */
    long countBySorteoIdAndEstado(Long sorteoId, EstadoBillete estado);

    /**
     * Cuenta total de billetes comprados por un cliente
     */
    long countByClienteId(Long clienteId);

    /**
     * Elimina un billete por su ID
     */
    void deleteById(Long id);

    /**
     * Verifica si existe un billete con el ID dado
     */
    boolean existsById(Long id);
}