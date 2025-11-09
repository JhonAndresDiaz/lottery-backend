package com.konex.lottery_backend.infrastructure.adapter.in.rest.mapper;

import com.konex.lottery_backend.application.dto.BilleteDTO;
import com.konex.lottery_backend.domain.model.Billete;
import com.konex.lottery_backend.domain.port.out.ClienteRepositoryPort;
import com.konex.lottery_backend.domain.port.out.SorteoRepositoryPort;
import com.konex.lottery_backend.infrastructure.adapter.in.rest.dto.response.BilleteResponse;
import org.springframework.stereotype.Component;

/**
 * Mapper REST para Billete
 */
@Component
public class BilleteRestMapper {

    private final SorteoRepositoryPort sorteoRepository;
    private final ClienteRepositoryPort clienteRepository;

    public BilleteRestMapper(SorteoRepositoryPort sorteoRepository,
                             ClienteRepositoryPort clienteRepository) {
        this.sorteoRepository = sorteoRepository;
        this.clienteRepository = clienteRepository;
    }

    /**
     * Convierte un modelo de dominio a respuesta REST
     */
    public BilleteResponse toResponse(Billete domainModel) {
        if (domainModel == null) {
            return null;
        }

        BilleteResponse response = new BilleteResponse();
        response.setId(domainModel.getId());
        response.setNumero(domainModel.getNumero());
        response.setPrecio(domainModel.getPrecio());
        response.setEstado(domainModel.getEstado());
        response.setFechaVenta(domainModel.getFechaVenta());
        response.setFechaCreacion(domainModel.getFechaCreacion());

        if (domainModel.getSorteoId() != null) {
            response.setSorteoId(domainModel.getSorteoId());
            sorteoRepository.findById(domainModel.getSorteoId()).ifPresent(sorteo -> {
                response.setSorteoNombre(sorteo.getNombre());
            });
        }

        if (domainModel.getClienteId() != null) {
            response.setClienteId(domainModel.getClienteId());
            clienteRepository.findById(domainModel.getClienteId()).ifPresent(cliente -> {
                response.setClienteNombre(cliente.getNombre());
                response.setClienteEmail(cliente.getEmail());
            });
        }

        return response;
    }

    /**
     * Convierte un Application DTO a respuesta REST
     */
    public BilleteResponse toResponse(BilleteDTO dto) {
        if (dto == null) {
            return null;
        }

        BilleteResponse response = new BilleteResponse();
        response.setId(dto.getId());
        response.setNumero(dto.getNumero());
        response.setPrecio(dto.getPrecio());
        response.setEstado(dto.getEstado());
        response.setSorteoId(dto.getSorteoId());
        response.setSorteoNombre(dto.getSorteoNombre());
        response.setClienteId(dto.getClienteId());
        response.setClienteNombre(dto.getClienteNombre());
        response.setClienteEmail(dto.getClienteEmail());
        response.setFechaVenta(dto.getFechaVenta());
        response.setFechaCreacion(dto.getFechaCreacion());

        return response;
    }
}

