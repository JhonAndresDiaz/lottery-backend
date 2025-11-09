package com.konex.lottery_backend.infrastructure.adapter.in.rest.exception;

import com.konex.lottery_backend.domain.exception.*;
import com.konex.lottery_backend.infrastructure.adapter.in.rest.dto.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Handler global de excepciones para la API REST
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja ValidationException del dominio
     * Status: 400 BAD REQUEST
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            ValidationException ex,
            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Error",
                ex.getMessage(),
                request.getRequestURI(),
                ex.getErrorCode()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /**
     * Maneja SorteoNotFoundException
     * Status: 404 NOT FOUND
     */
    @ExceptionHandler(SorteoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleSorteoNotFoundException(
            SorteoNotFoundException ex,
            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Sorteo Not Found",
                ex.getMessage(),
                request.getRequestURI(),
                ex.getErrorCode()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    /**
     * Maneja ClienteNotFoundException
     * Status: 404 NOT FOUND
     */
    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleClienteNotFoundException(
            ClienteNotFoundException ex,
            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Cliente Not Found",
                ex.getMessage(),
                request.getRequestURI(),
                ex.getErrorCode()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    /**
     * Maneja BilleteNotFoundException
     * Status: 404 NOT FOUND
     */
    @ExceptionHandler(BilleteNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBilleteNotFoundException(
            BilleteNotFoundException ex,
            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Billete Not Found",
                ex.getMessage(),
                request.getRequestURI(),
                ex.getErrorCode()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    /**
     * Maneja BilleteYaVendidoException
     * Status: 409 CONFLICTO
     */
    @ExceptionHandler(BilleteYaVendidoException.class)
    public ResponseEntity<ErrorResponse> handleBilleteYaVendidoException(
            BilleteYaVendidoException ex,
            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "Billete Ya Vendido",
                ex.getMessage(),
                request.getRequestURI(),
                ex.getErrorCode()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    /**
     * Maneja EmailDuplicadoException
     * Status: 409 CONFLICTO
     */
    @ExceptionHandler(EmailDuplicadoException.class)
    public ResponseEntity<ErrorResponse> handleEmailDuplicadoException(
            EmailDuplicadoException ex,
            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "Email Duplicado",
                ex.getMessage(),
                request.getRequestURI(),
                ex.getErrorCode()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    /**
     * Maneja DomainException genérica
     * Status: 400 BAD REQUEST
     */
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorResponse> handleDomainException(
            DomainException ex,
            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Domain Error",
                ex.getMessage(),
                request.getRequestURI(),
                ex.getErrorCode()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /**
     * Maneja errores de validación de Bean Validation (@Valid)
     * Status: 400 BAD REQUEST
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Error",
                "Error en la validación de los datos de entrada",
                request.getRequestURI()
        );

        // Agregar detalles de cada campo inválido
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            error.addDetail(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /**
     * Maneja cualquier otra excepción no contemplada
     * Status: 500 INTERNAL SERVER ERROR
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(
            Exception ex,
            HttpServletRequest request) {

        ex.printStackTrace();

        ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                "Ha ocurrido un error inesperado en el servidor",
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
