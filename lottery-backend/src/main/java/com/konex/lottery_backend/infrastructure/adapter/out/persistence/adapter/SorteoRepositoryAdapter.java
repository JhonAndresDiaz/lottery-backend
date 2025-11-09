package com.konex.lottery_backend.infrastructure.adapter.out.persistence.adapter;

import com.konex.lottery_backend.domain.model.Sorteo;
import com.konex.lottery_backend.domain.port.out.SorteoRepositoryPort;
import com.konex.lottery_backend.infrastructure.adapter.out.persistence.entity.SorteoJpaEntity;
import com.konex.lottery_backend.infrastructure.adapter.out.persistence.mapper.SorteoPersistenceMapper;
import com.konex.lottery_backend.infrastructure.adapter.out.persistence.repository.SorteoJpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Adaptador que implementa el puerto OUT SorteoRepositoryPort
 * Puente entre dominio y la capa de infraestructura
 */
@Component
public class SorteoRepositoryAdapter implements SorteoRepositoryPort {

    private final SorteoJpaRepository jpaRepository;
    private final SorteoPersistenceMapper mapper;

    public SorteoRepositoryAdapter(SorteoJpaRepository jpaRepository,
                                   SorteoPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Sorteo save(Sorteo sorteo) {
        // 1. Convertir dominio a JPA
        SorteoJpaEntity jpaEntity = mapper.toJpaEntity(sorteo);

        // 2. Persistir con JPA
        SorteoJpaEntity savedEntity = jpaRepository.save(jpaEntity);

        // 3. Convertir JPA a dominio
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Sorteo> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Sorteo> findAll() {
        return jpaRepository.findAllByOrderByFechaDesc()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Sorteo> findByFecha(LocalDate fecha) {
        return jpaRepository.findByFecha(fecha)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Sorteo> findByFechaGreaterThanEqual(LocalDate fecha) {
        return jpaRepository.findByFechaGreaterThanEqual(fecha)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Sorteo> findByNombreContaining(String nombre) {
        return jpaRepository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public long count() {
        return jpaRepository.count();
    }
}

