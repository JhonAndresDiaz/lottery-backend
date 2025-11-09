package com.konex.lottery_backend.infrastructure.adapter.out.persistence.repository;

import com.konex.lottery_backend.domain.model.EstadoBillete;
import com.konex.lottery_backend.infrastructure.adapter.out.persistence.entity.BilleteJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio JPA para BilleteJpaEntity
 */
@Repository
public interface BilleteJpaRepository extends JpaRepository<BilleteJpaEntity, Long> {

    /**
     * Busca todos los billetes de un sorteo específico
     */
    List<BilleteJpaEntity> findBySorteoId(Long sorteoId);

    /**
     * Busca billetes por estado
     */
    List<BilleteJpaEntity> findByEstado(EstadoBillete estado);

    /**
     * Busca billetes de un sorteo con un estado específico
     */
    List<BilleteJpaEntity> findBySorteoIdAndEstado(Long sorteoId, EstadoBillete estado);

    /**
     * Busca todos los billetes comprados por un cliente
     */
    List<BilleteJpaEntity> findByClienteId(Long clienteId);

    /**
     * Busca un billete por número dentro de un sorteo
     */
    Optional<BilleteJpaEntity> findByNumeroAndSorteoId(String numero, Long sorteoId);

    /**
     * Verifica si existe un billete con el número en un sorteo
     */
    boolean existsByNumeroAndSorteoId(String numero, Long sorteoId);

    /**
     * Cuenta billetes por estado en un sorteo
     */
    long countBySorteoIdAndEstado(Long sorteoId, EstadoBillete estado);

    /**
     * Cuenta billetes comprados por un cliente
     */
    long countByClienteId(Long clienteId);

    /**
     * Query personalizada con JPQL para obtener billetes vendidos de un sorteo
     */
    @Query("SELECT b FROM BilleteJpaEntity b WHERE b.sorteo.id = :sorteoId AND b.estado = 'VENDIDO'")
    List<BilleteJpaEntity> findBilletesVendidosBySorteo(@Param("sorteoId") Long sorteoId);
}
