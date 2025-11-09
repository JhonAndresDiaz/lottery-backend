package com.konex.lottery_backend.infrastructure.adapter.in.rest.mapper;

import com.konex.lottery_backend.application.dto.ClienteDTO;
import com.konex.lottery_backend.domain.model.Cliente;
import com.konex.lottery_backend.domain.port.out.BilleteRepositoryPort;
import com.konex.lottery_backend.infrastructure.adapter.in.rest.dto.response.ClienteResponse;
import org.springframework.stereotype.Component;

/**
 * Mapper REST para Cliente
 */
@Component
public class ClienteRestMapper {

    private final BilleteRepositoryPort billeteRepository;

    public ClienteRestMapper(BilleteRepositoryPort billeteRepository) {
        this.billeteRepository = billeteRepository;
    }

    /**
     * Convierte un modelo de dominio a respuesta REST
     */
    public ClienteResponse toResponse(Cliente domainModel) {
        if (domainModel == null) {
            return null;
        }

        ClienteResponse response = new ClienteResponse();
        response.setId(domainModel.getId());
        response.setNombre(domainModel.getNombre());
        response.setEmail(domainModel.getEmail());
        response.setFechaRegistro(domainModel.getFechaRegistro());

        if (domainModel.getId() != null) {
            long totalBilletes = billeteRepository.countByClienteId(domainModel.getId());
            response.setTotalBilletesComprados((int) totalBilletes);
        }

        return response;
    }

    /**
     * Convierte un Application DTO a respuesta REST
     */
    public ClienteResponse toResponse(ClienteDTO dto) {
        if (dto == null) {
            return null;
        }

        ClienteResponse response = new ClienteResponse();
        response.setId(dto.getId());
        response.setNombre(dto.getNombre());
        response.setEmail(dto.getEmail());
        response.setFechaRegistro(dto.getFechaRegistro());
        response.setTotalBilletesComprados(dto.getTotalBilletesComprados());

        return response;
    }

    /**
     * Convierte un modelo de dominio a respuesta REST con estadísticas ya calculadas
     */
    public ClienteResponse toResponseWithStats(Cliente domainModel, int totalBilletes) {
        if (domainModel == null) {
            return null;
        }

        ClienteResponse response = new ClienteResponse();
        response.setId(domainModel.getId());
        response.setNombre(domainModel.getNombre());
        response.setEmail(domainModel.getEmail());
        response.setFechaRegistro(domainModel.getFechaRegistro());
        response.setTotalBilletesComprados(totalBilletes);

        return response;
    }
}

