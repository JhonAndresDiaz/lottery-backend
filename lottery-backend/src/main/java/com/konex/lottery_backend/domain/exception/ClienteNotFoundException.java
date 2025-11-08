package com.konex.lottery_backend.domain.exception;

/**
 * Excepción lanzada cuando se intenta acceder a un Cliente que no existe
 */
public class ClienteNotFoundException extends DomainException {

    private static final String DEFAULT_MESSAGE = "Cliente no encontrado";
    private static final String ERROR_CODE = "CLIENTE_NOT_FOUND";

    /**
     * Constructor con ID del cliente no encontrado
     */
    public ClienteNotFoundException(Long clienteId) {
        super(
                String.format("Cliente con ID %d no encontrado", clienteId),
                ERROR_CODE
        );
    }

    /**
     * Constructor con email del cliente no encontrado
     */
    public ClienteNotFoundException(String email) {
        super(
                String.format("Cliente con email '%s' no encontrado", email),
                ERROR_CODE
        );
    }

    /**
     * Constructor por defecto
     */
    public ClienteNotFoundException() {
        super(DEFAULT_MESSAGE, ERROR_CODE);
    }
}