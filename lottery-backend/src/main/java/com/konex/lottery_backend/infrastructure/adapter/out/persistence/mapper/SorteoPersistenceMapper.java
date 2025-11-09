package com.konex.lottery_backend.infrastructure.adapter.out.persistence.mapper;

import com.konex.lottery_backend.domain.model.Sorteo;
import com.konex.lottery_backend.infrastructure.adapter.out.persistence.entity.SorteoJpaEntity;
import org.springframework.stereotype.Component;

/**
 * Mapper para convertir entre Sorteo (dominio) y SorteoJpaEntity (JPA)
 */
@Component
public class SorteoPersistenceMapper {

    /**
     * Convierte una entidad JPA a modelo de dominio
     */
    public Sorteo toDomain(SorteoJpaEntity jpaEntity) {
        if (jpaEntity == null) {
            return null;
        }

        Sorteo sorteo = new Sorteo();
        sorteo.setId(jpaEntity.getId());
        sorteo.setNombre(jpaEntity.getNombre());
        sorteo.setFecha(jpaEntity.getFecha());
        sorteo.setFechaCreacion(jpaEntity.getFechaCreacion());

        return sorteo;
    }

    /**
     * Convierte un modelo de dominio a entidad JPA
     */
    public SorteoJpaEntity toJpaEntity(Sorteo domainModel) {
        if (domainModel == null) {
            return null;
        }

        SorteoJpaEntity jpaEntity = new SorteoJpaEntity();
        jpaEntity.setId(domainModel.getId());
        jpaEntity.setNombre(domainModel.getNombre());
        jpaEntity.setFecha(domainModel.getFecha());
        jpaEntity.setFechaCreacion(domainModel.getFechaCreacion());

        return jpaEntity;
    }

    /**
     * Actualiza una entidad JPA existente con datos del dominio
     */
    public void updateJpaEntity(SorteoJpaEntity jpaEntity, Sorteo domainModel) {
        if (jpaEntity == null || domainModel == null) {
            return;
        }

        jpaEntity.setNombre(domainModel.getNombre());
        jpaEntity.setFecha(domainModel.getFecha());
    }
}
