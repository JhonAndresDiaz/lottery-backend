package com.konex.lottery_backend.infrastructure.adapter.out.persistence.mapper;

import com.konex.lottery_backend.domain.model.Billete;
import com.konex.lottery_backend.infrastructure.adapter.out.persistence.entity.BilleteJpaEntity;
import com.konex.lottery_backend.infrastructure.adapter.out.persistence.entity.ClienteJpaEntity;
import com.konex.lottery_backend.infrastructure.adapter.out.persistence.entity.SorteoJpaEntity;
import com.konex.lottery_backend.infrastructure.adapter.out.persistence.repository.ClienteJpaRepository;
import com.konex.lottery_backend.infrastructure.adapter.out.persistence.repository.SorteoJpaRepository;
import org.springframework.stereotype.Component;

/**
 * Mapper para convertir entre Billete (dominio) y BilleteJpaEntity (JPA)
 */
@Component
public class BilletePersistenceMapper {

    private final SorteoJpaRepository sorteoJpaRepository;
    private final ClienteJpaRepository clienteJpaRepository;

    public BilletePersistenceMapper(SorteoJpaRepository sorteoJpaRepository,
                                    ClienteJpaRepository clienteJpaRepository) {
        this.sorteoJpaRepository = sorteoJpaRepository;
        this.clienteJpaRepository = clienteJpaRepository;
    }

    /**
     * Convierte una entidad JPA a modelo de dominio
     */
    public Billete toDomain(BilleteJpaEntity jpaEntity) {
        if (jpaEntity == null) {
            return null;
        }

        Billete billete = new Billete();
        billete.setId(jpaEntity.getId());
        billete.setNumero(jpaEntity.getNumero());
        billete.setPrecio(jpaEntity.getPrecio());
        billete.setEstado(jpaEntity.getEstado());
        billete.setFechaVenta(jpaEntity.getFechaVenta());
        billete.setFechaCreacion(jpaEntity.getFechaCreacion());

        if (jpaEntity.getSorteo() != null) {
            billete.setSorteoId(jpaEntity.getSorteo().getId());
        }

        if (jpaEntity.getCliente() != null) {
            billete.setClienteId(jpaEntity.getCliente().getId());
        }

        return billete;
    }

    /**
     * Convierte un modelo de dominio a entidad JPA
     */
    public BilleteJpaEntity toJpaEntity(Billete domainModel) {
        if (domainModel == null) {
            return null;
        }

        BilleteJpaEntity jpaEntity = new BilleteJpaEntity();
        jpaEntity.setId(domainModel.getId());
        jpaEntity.setNumero(domainModel.getNumero());
        jpaEntity.setPrecio(domainModel.getPrecio());
        jpaEntity.setEstado(domainModel.getEstado());
        jpaEntity.setFechaVenta(domainModel.getFechaVenta());
        jpaEntity.setFechaCreacion(domainModel.getFechaCreacion());

        if (domainModel.getSorteoId() != null) {
            SorteoJpaEntity sorteo = sorteoJpaRepository.getReferenceById(domainModel.getSorteoId());
            jpaEntity.setSorteo(sorteo);
        }

        if (domainModel.getClienteId() != null) {
            ClienteJpaEntity cliente = clienteJpaRepository.getReferenceById(domainModel.getClienteId());
            jpaEntity.setCliente(cliente);
        }

        return jpaEntity;
    }

    /**
     * Actualiza una entidad JPA existente con datos del dominio
     */
    public void updateJpaEntity(BilleteJpaEntity jpaEntity, Billete domainModel) {
        if (jpaEntity == null || domainModel == null) {
            return;
        }

        jpaEntity.setNumero(domainModel.getNumero());
        jpaEntity.setPrecio(domainModel.getPrecio());
        jpaEntity.setEstado(domainModel.getEstado());
        jpaEntity.setFechaVenta(domainModel.getFechaVenta());

        if (domainModel.getClienteId() != null &&
                (jpaEntity.getCliente() == null ||
                        !jpaEntity.getCliente().getId().equals(domainModel.getClienteId()))) {
            ClienteJpaEntity cliente = clienteJpaRepository.getReferenceById(domainModel.getClienteId());
            jpaEntity.setCliente(cliente);
        }

    }
}
