package com.konex.lottery_backend.application.service.billete;

import com.konex.lottery_backend.domain.exception.BilleteNotFoundException;
import com.konex.lottery_backend.domain.exception.BilleteYaVendidoException;
import com.konex.lottery_backend.domain.exception.ClienteNotFoundException;
import com.konex.lottery_backend.domain.model.Billete;
import com.konex.lottery_backend.domain.port.in.billete.VenderBilleteUseCase;
import com.konex.lottery_backend.domain.port.out.BilleteRepositoryPort;
import com.konex.lottery_backend.domain.port.out.ClienteRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio que implementa el caso de uso: Vender Billete
 */
@Service
@Transactional
public class VenderBilleteService implements VenderBilleteUseCase {

    private final BilleteRepositoryPort billeteRepository;
    private final ClienteRepositoryPort clienteRepository;

    public VenderBilleteService(BilleteRepositoryPort billeteRepository,
                                ClienteRepositoryPort clienteRepository) {
        this.billeteRepository = billeteRepository;
        this.clienteRepository = clienteRepository;
    }

    /**
     * Ejecuta el caso de uso: vender un billete a un cliente
     */
    @Override
    public Billete execute(Long billeteId, Long clienteId) {
        // 1. Verificar que el billete exista
        Billete billete = billeteRepository.findById(billeteId)
                .orElseThrow(() -> new BilleteNotFoundException(billeteId));

        // 2. Verificar que el cliente exista
        if (!clienteRepository.existsById(clienteId)) {
            throw new ClienteNotFoundException(clienteId);
        }

        // 3. Verificar que el billete NO esté vendido
        if (!billete.puedeVenderse()) {
            throw new BilleteYaVendidoException(
                    billeteId,
                    billete.getClienteId()
            );
        }

        billete.vender(clienteId);
        Billete billeteVendido = billeteRepository.save(billete);
        return billeteVendido;
    }
}
