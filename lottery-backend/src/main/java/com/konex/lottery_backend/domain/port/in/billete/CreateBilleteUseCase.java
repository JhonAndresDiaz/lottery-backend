package com.konex.lottery_backend.domain.port.in.billete;

import com.konex.lottery_backend.domain.model.Billete;

import java.math.BigDecimal;

/**
 * Reglas de negocio aplicadas:
 * - El número es obligatorio
 * - El precio debe ser mayor a cero
 * - El sorteo debe existir
 * - El número debe ser único dentro del sorteo
 */
public interface CreateBilleteUseCase {

    /**
     * Crea un nuevo billete en el sistema
     */
    Billete execute(String numero, BigDecimal precio, Long sorteoId);
}
