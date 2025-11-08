package com.konex.lottery_backend.domain.port.in.cliente;

import com.konex.lottery_backend.domain.model.Cliente;

/**
 * Reglas de negocio aplicadas:
 * - El nombre es obligatorio
 * - El email es obligatorio y debe tener formato válido
 * - El email debe ser ÚNICO en el sistema
 */
public interface CreateClienteUseCase {

    /**
     * Crea un nuevo cliente en el sistema
     */
    Cliente execute(String nombre, String email);
}
