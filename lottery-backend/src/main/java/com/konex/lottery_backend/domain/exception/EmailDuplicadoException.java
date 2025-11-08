package com.konex.lottery_backend.domain.exception;

/**
 * Excepción lanzada cuando se intenta registrar un cliente con un email
 * que ya existe en el sistema
 */
public class EmailDuplicadoException extends DomainException {

    private static final String ERROR_CODE = "EMAIL_DUPLICADO";

    /**
     * Constructor con el email duplicado
     */
    public EmailDuplicadoException(String email) {
        super(
                String.format("Ya existe un cliente registrado con el email '%s'", email),
                ERROR_CODE
        );
    }

    /**
     * Constructor por defecto
     */
    public EmailDuplicadoException() {
        super("El email ya está registrado en el sistema", ERROR_CODE);
    }
}