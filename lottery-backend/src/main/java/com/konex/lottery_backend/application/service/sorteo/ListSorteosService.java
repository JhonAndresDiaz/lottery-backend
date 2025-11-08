package com.konex.lottery_backend.application.service.sorteo;

import com.konex.lottery_backend.domain.model.Sorteo;
import com.konex.lottery_backend.domain.port.in.sorteo.ListSorteosUseCase;
import com.konex.lottery_backend.domain.port.out.SorteoRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Servicio que implementa el caso de uso: Listar Sorteos
 */
@Service
@Transactional(readOnly = true)
public class ListSorteosService implements ListSorteosUseCase {

    private final SorteoRepositoryPort sorteoRepository;

    public ListSorteosService(SorteoRepositoryPort sorteoRepository) {
        this.sorteoRepository = sorteoRepository;
    }

    /**
     * Lista todos los sorteos ordenados por fecha descendente
     */
    @Override
    public List<Sorteo> execute() {
        return sorteoRepository.findAll();
    }
}
