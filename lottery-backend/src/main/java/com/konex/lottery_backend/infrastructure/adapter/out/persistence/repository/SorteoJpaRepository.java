package com.konex.lottery_backend.infrastructure.adapter.out.persistence.repository;

import com.konex.lottery_backend.infrastructure.adapter.out.persistence.entity.SorteoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repositorio JPA para SorteoJpaEntity
 * Proporciona métodos CRUD y métodos de consulta personalizados
 * La implementación es generada automáticamente por Spring Data JPA
 */
@Repository
public interface SorteoJpaRepository extends JpaRepository<SorteoJpaEntity, Long> {

    /**
     * Busca sorteos por fecha específica
     */
    List<SorteoJpaEntity> findByFecha(LocalDate fecha);

    /**
     * Busca sorteos con fecha mayor o igual a la dada
     */
    List<SorteoJpaEntity> findByFechaGreaterThanEqual(LocalDate fecha);

    /**
     * Busca sorteos por nombre (búsqueda parcial, case insensitive)
     */
    List<SorteoJpaEntity> findByNombreContainingIgnoreCase(String nombre);

    /**
     * Obtiene todos los sorteos ordenados por fecha descendente
     */
    List<SorteoJpaEntity> findAllByOrderByFechaDesc();
}
