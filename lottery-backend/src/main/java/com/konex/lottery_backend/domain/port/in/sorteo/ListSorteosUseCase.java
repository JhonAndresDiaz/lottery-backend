package com.konex.lottery_backend.domain.port.in.sorteo;

import com.konex.lottery_backend.domain.model.Sorteo;

import java.util.List;

/**
 * Obtener todos los sorteos del sistema
 */
public interface ListSorteosUseCase {

    /**
     * Lista todos los sorteos del sistema
     */
    List<Sorteo> execute();
}
