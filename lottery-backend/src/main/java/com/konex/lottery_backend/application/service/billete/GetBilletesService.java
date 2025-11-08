package com.konex.lottery_backend.application.service.billete;

import com.konex.lottery_backend.domain.exception.BilleteNotFoundException;
import com.konex.lottery_backend.domain.exception.ClienteNotFoundException;
import com.konex.lottery_backend.domain.exception.SorteoNotFoundException;
import com.konex.lottery_backend.domain.model.Billete;
import com.konex.lottery_backend.domain.model.EstadoBillete;
import com.konex.lottery_backend.domain.port.in.billete.GetBilletesUseCase;
import com.konex.lottery_backend.domain.port.out.BilleteRepositoryPort;
import com.konex.lottery_backend.domain.port.out.ClienteRepositoryPort;
import com.konex.lottery_backend.domain.port.out.SorteoRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Servicio que implementa el caso de uso: Obtener Billetes con filtros
 */
@Service
@Transactional(readOnly = true)
public class GetBilletesService implements GetBilletesUseCase {

    private final BilleteRepositoryPort billeteRepository;
    private final SorteoRepositoryPort sorteoRepository;
    private final ClienteRepositoryPort clienteRepository;

    public GetBilletesService(BilleteRepositoryPort billeteRepository,
                              SorteoRepositoryPort sorteoRepository,
                              ClienteRepositoryPort clienteRepository) {
        this.billeteRepository = billeteRepository;
        this.sorteoRepository = sorteoRepository;
        this.clienteRepository = clienteRepository;
    }

    /**
     * Obtiene todos los billetes del sistema
     */
    @Override
    public List<Billete> getAll() {
        return billeteRepository.findAll();
    }

    /**
     * Obtiene todos los billetes de un sorteo
     */
    @Override
    public List<Billete> getBySorteo(Long sorteoId) {
        if (!sorteoRepository.existsById(sorteoId)) {
            throw new SorteoNotFoundException(sorteoId);
        }

        return billeteRepository.findBySorteoId(sorteoId);
    }

    /**
     * Obtiene solo los billetes DISPONIBLES de un sorteo
     */
    @Override
    public List<Billete> getDisponiblesBySorteo(Long sorteoId) {
        // Validar que el sorteo exista
        if (!sorteoRepository.existsById(sorteoId)) {
            throw new SorteoNotFoundException(sorteoId);
        }

        return billeteRepository.findBySorteoIdAndEstado(sorteoId, EstadoBillete.DISPONIBLE);
    }

    /**
     * Obtiene todos los billetes comprados por un cliente
     */
    @Override
    public List<Billete> getByCliente(Long clienteId) {
        // Validar que el cliente exista
        if (!clienteRepository.existsById(clienteId)) {
            throw new ClienteNotFoundException(clienteId);
        }

        return billeteRepository.findByClienteId(clienteId);
    }

    /**
     * Obtiene un billete específico por su ID
     */
    @Override
    public Billete getById(Long billeteId) {
        return billeteRepository.findById(billeteId)
                .orElseThrow(() -> new BilleteNotFoundException(billeteId));
    }
}
