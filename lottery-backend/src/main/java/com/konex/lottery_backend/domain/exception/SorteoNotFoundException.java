package com.konex.lottery_backend.domain.exception;

/**
 * Excepción lanzada cuando se intenta acceder a un Sorteo que no existe
 */
public class SorteoNotFoundException extends DomainException {

    private static final String DEFAULT_MESSAGE = "Sorteo no encontrado";
    private static final String ERROR_CODE = "SORTEO_NOT_FOUND";

    /**
     * Constructor con ID del sorteo no encontrado
     */
    public SorteoNotFoundException(Long sorteoId) {
        super(
                String.format("Sorteo con ID %d no encontrado", sorteoId),
                ERROR_CODE
        );
    }

    /**
     * Constructor con mensaje personalizado
     */
    public SorteoNotFoundException(String message) {
        super(message, ERROR_CODE);
    }

    /**
     * Constructor por defecto
     */
    public SorteoNotFoundException() {
        super(DEFAULT_MESSAGE, ERROR_CODE);
    }
}