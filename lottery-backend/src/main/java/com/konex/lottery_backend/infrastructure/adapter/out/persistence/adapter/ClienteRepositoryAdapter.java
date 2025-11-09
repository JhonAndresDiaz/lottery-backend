package com.konex.lottery_backend.infrastructure.adapter.out.persistence.adapter;

import com.konex.lottery_backend.domain.model.Cliente;
import com.konex.lottery_backend.domain.port.out.ClienteRepositoryPort;
import com.konex.lottery_backend.infrastructure.adapter.out.persistence.entity.ClienteJpaEntity;
import com.konex.lottery_backend.infrastructure.adapter.out.persistence.mapper.ClientePersistenceMapper;
import com.konex.lottery_backend.infrastructure.adapter.out.persistence.repository.ClienteJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Adaptador que implementa el puerto OUT ClienteRepositoryPort
 * Conecta el dominio con la persistencia JPA para clientes.
 */
@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteJpaRepository jpaRepository;
    private final ClientePersistenceMapper mapper;

    public ClienteRepositoryAdapter(ClienteJpaRepository jpaRepository,
                                    ClientePersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Cliente save(Cliente cliente) {
        ClienteJpaEntity jpaEntity = mapper.toJpaEntity(cliente);
        ClienteJpaEntity savedEntity = jpaRepository.save(jpaEntity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Cliente> findByEmail(String email) {
        return jpaRepository.findByEmail(email)
                .map(mapper::toDomain);
    }

    @Override
    public List<Cliente> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Cliente> findByNombreContaining(String nombre) {
        return jpaRepository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public long count() {
        return jpaRepository.count();
    }
}
