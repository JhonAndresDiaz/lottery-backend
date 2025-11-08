package com.konex.lottery_backend.domain.exception;

/**
 * Excepción base para todas las excepciones del dominio
 */
public class DomainException extends RuntimeException {

    /**
     * Código de error asociado a la excepción (opcional)
     */
    private String errorCode;

    /**
     * Constructor con mensaje
     */
    public DomainException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa
     */
    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor con mensaje y código de error
     */
    public DomainException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * Constructor completo
     */
    public DomainException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

