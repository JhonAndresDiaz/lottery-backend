package com.konex.lottery_backend.application.service.sorteo;

import com.konex.lottery_backend.domain.exception.SorteoNotFoundException;
import com.konex.lottery_backend.domain.model.Sorteo;
import com.konex.lottery_backend.domain.port.in.sorteo.GetSorteoUseCase;
import com.konex.lottery_backend.domain.port.out.SorteoRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio que implementa el caso de uso: Obtener Sorteo por ID
 */
@Service
@Transactional(readOnly = true)
public class GetSorteoService implements GetSorteoUseCase {

    private final SorteoRepositoryPort sorteoRepository;

    public GetSorteoService(SorteoRepositoryPort sorteoRepository) {
        this.sorteoRepository = sorteoRepository;
    }

    /**
     * Obtiene un sorteo por su ID
     */
    @Override
    public Sorteo execute(Long id) {
        return sorteoRepository.findById(id)
                .orElseThrow(() -> new SorteoNotFoundException(id));
    }
}