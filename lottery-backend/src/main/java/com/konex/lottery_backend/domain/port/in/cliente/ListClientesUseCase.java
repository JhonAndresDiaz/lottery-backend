package com.konex.lottery_backend.domain.port.in.cliente;

import com.konex.lottery_backend.domain.model.Cliente;

import java.util.List;

/**
 * Obtener todos los clientes del sistema
 */
public interface ListClientesUseCase {

    /**
     * Lista todos los clientes del sistema
     */
    List<Cliente> execute();
}