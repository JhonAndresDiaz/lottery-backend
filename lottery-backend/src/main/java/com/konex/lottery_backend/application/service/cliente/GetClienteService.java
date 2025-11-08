package com.konex.lottery_backend.application.service.cliente;

import com.konex.lottery_backend.domain.exception.ClienteNotFoundException;
import com.konex.lottery_backend.domain.model.Cliente;
import com.konex.lottery_backend.domain.port.in.cliente.GetClienteUseCase;
import com.konex.lottery_backend.domain.port.out.ClienteRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio que implementa el caso de uso: Obtener Cliente por ID
 */
@Service
@Transactional(readOnly = true)
public class GetClienteService implements GetClienteUseCase {

    private final ClienteRepositoryPort clienteRepository;

    public GetClienteService(ClienteRepositoryPort clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Obtiene un cliente por su ID
     */
    @Override
    public Cliente execute(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }
}