package com.konex.lottery_backend.domain.exception;

/**
 * Excepción lanzada cuando se intenta vender un billete que ya fue vendido
 */
public class BilleteYaVendidoException extends DomainException {

    private static final String ERROR_CODE = "BILLETE_YA_VENDIDO";

    /**
     * Constructor con ID del billete
     */
    public BilleteYaVendidoException(Long billeteId) {
        super(
                String.format("El billete con ID %d ya ha sido vendido y no puede venderse nuevamente", billeteId),
                ERROR_CODE
        );
    }

    /**
     * Constructor con número de billete
     */
    public BilleteYaVendidoException(String numeroBillete) {
        super(
                String.format("El billete número '%s' ya ha sido vendido y no puede venderse nuevamente", numeroBillete),
                ERROR_CODE
        );
    }

    /**
     * Constructor con ID de billete y cliente actual
     */
    public BilleteYaVendidoException(Long billeteId, Long clienteId) {
        super(
                String.format("El billete con ID %d ya fue vendido al cliente con ID %d", billeteId, clienteId),
                ERROR_CODE
        );
    }

    /**
     * Constructor con mensaje personalizado
     */
    public BilleteYaVendidoException(String message, boolean isCustomMessage) {
        super(message, ERROR_CODE);
    }
}
