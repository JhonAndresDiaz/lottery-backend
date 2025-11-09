package com.konex.lottery_backend.infrastructure.adapter.out.persistence.mapper;

import com.konex.lottery_backend.domain.model.Cliente;
import com.konex.lottery_backend.infrastructure.adapter.out.persistence.entity.ClienteJpaEntity;
import org.springframework.stereotype.Component;

/**
 * Mapper para convertir entre Cliente (dominio) y ClienteJpaEntity (JPA)
 */
@Component
public class ClientePersistenceMapper {

    /**
     * Convierte una entidad JPA a modelo de dominio
     */
    public Cliente toDomain(ClienteJpaEntity jpaEntity) {
        if (jpaEntity == null) {
            return null;
        }

        Cliente cliente = new Cliente();
        cliente.setId(jpaEntity.getId());
        cliente.setNombre(jpaEntity.getNombre());
        cliente.setEmail(jpaEntity.getEmail());
        cliente.setFechaRegistro(jpaEntity.getFechaRegistro());

        return cliente;
    }

    /**
     * Convierte un modelo de dominio a entidad JPA
     */
    public ClienteJpaEntity toJpaEntity(Cliente domainModel) {
        if (domainModel == null) {
            return null;
        }

        ClienteJpaEntity jpaEntity = new ClienteJpaEntity();
        jpaEntity.setId(domainModel.getId());
        jpaEntity.setNombre(domainModel.getNombre());
        jpaEntity.setEmail(domainModel.getEmail());
        jpaEntity.setFechaRegistro(domainModel.getFechaRegistro());

        return jpaEntity;
    }

    /**
     * Actualiza una entidad JPA existente con datos del dominio
     */
    public void updateJpaEntity(ClienteJpaEntity jpaEntity, Cliente domainModel) {
        if (jpaEntity == null || domainModel == null) {
            return;
        }

        jpaEntity.setNombre(domainModel.getNombre());
        jpaEntity.setEmail(domainModel.getEmail());
    }
}
