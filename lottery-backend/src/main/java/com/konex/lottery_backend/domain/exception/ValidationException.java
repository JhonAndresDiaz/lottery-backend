package com.konex.lottery_backend.domain.exception;


/**
 * Excepción lanzada cuando se viola una regla de validación del dominio
 */
public class ValidationException extends DomainException {

    private static final String ERROR_CODE = "VALIDATION_ERROR";

    /**
     * Constructor con mensaje de validación
     */
    public ValidationException(String message) {
        super(message, ERROR_CODE);
    }

    /**
     * Constructor con campo y mensaje
     */
    public ValidationException(String field, String message) {
        super(
                String.format("Error de validación en el campo '%s': %s", field, message),
                ERROR_CODE
        );
    }
}