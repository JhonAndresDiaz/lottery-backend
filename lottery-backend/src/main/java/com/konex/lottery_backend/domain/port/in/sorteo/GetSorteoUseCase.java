package com.konex.lottery_backend.domain.port.in.sorteo;

import com.konex.lottery_backend.domain.model.Sorteo;

/**
 * Buscar el sorteo por ID
 */
public interface GetSorteoUseCase {

    /**
     * Obtiene un sorteo por su ID
     */
    Sorteo execute(Long id);
}