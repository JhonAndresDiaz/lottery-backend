package com.konex.lottery_backend.domain.port.in.cliente;


import com.konex.lottery_backend.domain.model.Cliente;

/**
 * Buscar el cliente por ID
 */
public interface GetClienteUseCase {

    /**
     * Obtiene un cliente por su ID
     */
    Cliente execute(Long id);
}
