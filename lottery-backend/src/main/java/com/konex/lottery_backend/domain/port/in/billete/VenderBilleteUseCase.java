package com.konex.lottery_backend.domain.port.in.billete;

import com.konex.lottery_backend.domain.model.Billete;

/**
 * Vender un billete a un cliente con su id
 */
public interface VenderBilleteUseCase {

    /**
     * Vende un billete a un cliente
     */
    Billete execute(Long billeteId, Long clienteId);
}
