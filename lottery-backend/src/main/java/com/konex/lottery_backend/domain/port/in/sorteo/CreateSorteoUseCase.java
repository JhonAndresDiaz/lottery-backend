package com.konex.lottery_backend.domain.port.in.sorteo;

import com.konex.lottery_backend.domain.model.Sorteo;

import java.time.LocalDate;

/**
 * Reglas de negocio aplicadas:
 * - El nombre es obligatorio
 * - La fecha debe ser futura (no se pueden crear sorteos en el pasado)
 */
public interface CreateSorteoUseCase {

    /**
     * Crea un nuevo sorteo en el sistema
     */
    Sorteo execute(String nombre, LocalDate fecha);
}

