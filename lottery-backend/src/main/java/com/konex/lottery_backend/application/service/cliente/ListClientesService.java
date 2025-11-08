package com.konex.lottery_backend.application.service.cliente;

import com.konex.lottery_backend.domain.model.Cliente;
import com.konex.lottery_backend.domain.port.in.cliente.ListClientesUseCase;
import com.konex.lottery_backend.domain.port.out.ClienteRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Servicio que implementa el caso de uso: Listar Clientes
 */
@Service
@Transactional(readOnly = true)
public class ListClientesService implements ListClientesUseCase {

    private final ClienteRepositoryPort clienteRepository;

    public ListClientesService(ClienteRepositoryPort clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Lista todos los clientes del sistema
     */
    @Override
    public List<Cliente> execute() {
        return clienteRepository.findAll();
    }
}