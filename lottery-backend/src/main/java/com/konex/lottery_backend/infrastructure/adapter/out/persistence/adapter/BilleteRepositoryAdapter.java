package com.konex.lottery_backend.infrastructure.adapter.out.persistence.adapter;

import com.konex.lottery_backend.domain.model.Billete;
import com.konex.lottery_backend.domain.model.EstadoBillete;
import com.konex.lottery_backend.domain.port.out.BilleteRepositoryPort;
import com.konex.lottery_backend.infrastructure.adapter.out.persistence.entity.BilleteJpaEntity;
import com.konex.lottery_backend.infrastructure.adapter.out.persistence.mapper.BilletePersistenceMapper;
import com.konex.lottery_backend.infrastructure.adapter.out.persistence.repository.BilleteJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Adaptador que implementa el puerto OUT BilleteRepositoryPort
 */
@Component
public class BilleteRepositoryAdapter implements BilleteRepositoryPort {

    private final BilleteJpaRepository jpaRepository;
    private final BilletePersistenceMapper mapper;

    public BilleteRepositoryAdapter(BilleteJpaRepository jpaRepository,
                                    BilletePersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Billete save(Billete billete) {
        BilleteJpaEntity jpaEntity = mapper.toJpaEntity(billete);
        BilleteJpaEntity savedEntity = jpaRepository.save(jpaEntity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Billete> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Billete> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Billete> findBySorteoId(Long sorteoId) {
        return jpaRepository.findBySorteoId(sorteoId)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Billete> findByEstado(EstadoBillete estado) {
        return jpaRepository.findByEstado(estado)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Billete> findBySorteoIdAndEstado(Long sorteoId, EstadoBillete estado) {
        return jpaRepository.findBySorteoIdAndEstado(sorteoId, estado)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Billete> findByClienteId(Long clienteId) {
        return jpaRepository.findByClienteId(clienteId)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Billete> findByNumeroAndSorteoId(String numero, Long sorteoId) {
        return jpaRepository.findByNumeroAndSorteoId(numero, sorteoId)
                .map(mapper::toDomain);
    }

    @Override
    public boolean existsByNumeroAndSorteoId(String numero, Long sorteoId) {
        return jpaRepository.existsByNumeroAndSorteoId(numero, sorteoId);
    }

    @Override
    public long countBySorteoIdAndEstado(Long sorteoId, EstadoBillete estado) {
        return jpaRepository.countBySorteoIdAndEstado(sorteoId, estado);
    }

    @Override
    public long countByClienteId(Long clienteId) {
        return jpaRepository.countByClienteId(clienteId);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }
}

