package com.konex.lottery_backend.infrastructure.adapter.in.rest.mapper;

import com.konex.lottery_backend.application.dto.SorteoDTO;
import com.konex.lottery_backend.domain.model.EstadoBillete;
import com.konex.lottery_backend.domain.model.Sorteo;
import com.konex.lottery_backend.domain.port.out.BilleteRepositoryPort;
import com.konex.lottery_backend.infrastructure.adapter.in.rest.dto.response.SorteoResponse;
import org.springframework.stereotype.Component;

/**
 * Mapper REST para Sorteo.
 */
@Component
public class SorteoRestMapper {

    private final BilleteRepositoryPort billeteRepository;

    public SorteoRestMapper(BilleteRepositoryPort billeteRepository) {
        this.billeteRepository = billeteRepository;
    }

    /**
     * Convierte un modelo de dominio a respuesta REST
     */
    public SorteoResponse toResponse(Sorteo domainModel) {
        if (domainModel == null) {
            return null;
        }

        SorteoResponse response = new SorteoResponse();
        response.setId(domainModel.getId());
        response.setNombre(domainModel.getNombre());
        response.setFecha(domainModel.getFecha());
        response.setFechaCreacion(domainModel.getFechaCreacion());

        if (domainModel.getId() != null) {
            long totalBilletes = billeteRepository.findBySorteoId(domainModel.getId()).size();
            long disponibles = billeteRepository.countBySorteoIdAndEstado(
                    domainModel.getId(), EstadoBillete.DISPONIBLE
            );
            long vendidos = billeteRepository.countBySorteoIdAndEstado(
                    domainModel.getId(), EstadoBillete.VENDIDO
            );

            response.setTotalBilletes((int) totalBilletes);
            response.setBilletesDisponibles((int) disponibles);
            response.setBilletesVendidos((int) vendidos);
        }

        return response;
    }

    /**
     * Convierte un Application DTO a respuesta REST
     */
    public SorteoResponse toResponse(SorteoDTO dto) {
        if (dto == null) {
            return null;
        }

        SorteoResponse response = new SorteoResponse();
        response.setId(dto.getId());
        response.setNombre(dto.getNombre());
        response.setFecha(dto.getFecha());
        response.setFechaCreacion(dto.getFechaCreacion());
        response.setTotalBilletes(dto.getTotalBilletes());
        response.setBilletesDisponibles(dto.getBilletesDisponibles());
        response.setBilletesVendidos(dto.getBilletesVendidos());

        return response;
    }

    /**
     * Convierte un modelo de dominio a respuesta REST con estadísticas ya calculadas
     */
    public SorteoResponse toResponseWithStats(Sorteo domainModel, int totalBilletes,
                                              int disponibles, int vendidos) {
        if (domainModel == null) {
            return null;
        }

        SorteoResponse response = new SorteoResponse();
        response.setId(domainModel.getId());
        response.setNombre(domainModel.getNombre());
        response.setFecha(domainModel.getFecha());
        response.setFechaCreacion(domainModel.getFechaCreacion());
        response.setTotalBilletes(totalBilletes);
        response.setBilletesDisponibles(disponibles);
        response.setBilletesVendidos(vendidos);

        return response;
    }
}
