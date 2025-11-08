package com.konex.lottery_backend.domain.exception;

/**
 * Excepción lanzada cuando se intenta acceder a un Billete que no existe
 */
public class BilleteNotFoundException extends DomainException {

    private static final String DEFAULT_MESSAGE = "Billete no encontrado";
    private static final String ERROR_CODE = "BILLETE_NOT_FOUND";

    /**
     * Constructor con ID del billete no encontrado
     */
    public BilleteNotFoundException(Long billeteId) {
        super(
                String.format("Billete con ID %d no encontrado", billeteId),
                ERROR_CODE
        );
    }

    /**
     * Constructor con número y sorteo del billete no encontrado
     */
    public BilleteNotFoundException(String numero, Long sorteoId) {
        super(
                String.format("Billete número '%s' del sorteo %d no encontrado", numero, sorteoId),
                ERROR_CODE
        );
    }

    /**
     * Constructor con mensaje personalizado
     */
    public BilleteNotFoundException(String message) {
        super(message, ERROR_CODE);
    }

    /**
     * Constructor por defecto
     */
    public BilleteNotFoundException() {
        super(DEFAULT_MESSAGE, ERROR_CODE);
    }
}

