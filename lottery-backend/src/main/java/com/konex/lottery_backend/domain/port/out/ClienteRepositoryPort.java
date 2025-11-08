package com.konex.lottery_backend.domain.port.out;

import com.konex.lottery_backend.domain.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositoryPort {

    /**
     * Guarda un cliente
     */
    Cliente save(Cliente cliente);

    /**
     * Busca un cliente por su ID
     */
    Optional<Cliente> findById(Long id);

    /**
     * Busca un cliente por su email
     */
    Optional<Cliente> findByEmail(String email);

    /**
     * Obtiene todos los clientes del sistema
     */
    List<Cliente> findAll();

    /**
     * Busca clientes por nombre
     */
    List<Cliente> findByNombreContaining(String nombre);

    /**
     * Verifica si existe un cliente con el email dado
     */
    boolean existsByEmail(String email);

    /**
     * Verifica si existe un cliente con el ID dado
     */
    boolean existsById(Long id);

    /**
     * Elimina un cliente por su ID
     */
    void deleteById(Long id);

    /**
     * Cuenta el total de clientes en el sistema
     */
    long count();
}

