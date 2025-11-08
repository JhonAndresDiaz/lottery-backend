package com.konex.lottery_backend.domain.port.in.billete;

import com.konex.lottery_backend.domain.model.Billete;

import java.util.List;

/**
 * Agrupa varias consultas relacionadas con billetes.
 */
public interface GetBilletesUseCase {

    /**
     * Obtiene todos los billetes del sistema
     */
    List<Billete> getAll();

    /**
     * Obtiene todos los billetes de un sorteo específico
     */
    List<Billete> getBySorteo(Long sorteoId);

    /**
     * Obtiene solo los billetes DISPONIBLES de un sorteo
     */
    List<Billete> getDisponiblesBySorteo(Long sorteoId);

    /**
     * Obtiene todos los billetes comprados por un cliente
     */
    List<Billete> getByCliente(Long clienteId);

    /**
     * Obtiene un billete específico por su ID
     */
    Billete getById(Long billeteId);
}
