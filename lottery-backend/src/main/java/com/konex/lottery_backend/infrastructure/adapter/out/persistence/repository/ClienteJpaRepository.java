package com.konex.lottery_backend.infrastructure.adapter.out.persistence.repository;

import com.konex.lottery_backend.infrastructure.adapter.out.persistence.entity.ClienteJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio JPA para ClienteJpaEntity
 * Proporciona métodos CRUD y consultas personalizadas para clientes.
 * La implementación es generada automáticamente por Spring Data JPA.
 */
@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteJpaEntity, Long> {

    /**
     * Busca un cliente por su email
     */
    Optional<ClienteJpaEntity> findByEmail(String email);

    /**
     * Verifica si existe un cliente con el email dado
     */
    boolean existsByEmail(String email);

    /**
     * Busca clientes por nombre
     */
    List<ClienteJpaEntity> findByNombreContainingIgnoreCase(String nombre);
}