package com.konex.lottery_backend.infrastructure.adapter.in.rest.controller;

import com.konex.lottery_backend.domain.model.Sorteo;
import com.konex.lottery_backend.domain.port.in.sorteo.CreateSorteoUseCase;
import com.konex.lottery_backend.domain.port.in.sorteo.GetSorteoUseCase;
import com.konex.lottery_backend.domain.port.in.sorteo.ListSorteosUseCase;
import com.konex.lottery_backend.infrastructure.adapter.in.rest.dto.request.CreateSorteoRequest;
import com.konex.lottery_backend.infrastructure.adapter.in.rest.dto.response.SorteoResponse;
import com.konex.lottery_backend.infrastructure.adapter.in.rest.mapper.SorteoRestMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller REST para Sorteos.
 * ADAPTADOR DE ENTRADA para gestión de sorteo
 */
@RestController
@RequestMapping("/api/sorteos")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201"})
@Tag(name = "Sorteos", description = "API para gestión de sorteos")
public class SorteoController {

    private final CreateSorteoUseCase createSorteoUseCase;
    private final GetSorteoUseCase getSorteoUseCase;
    private final ListSorteosUseCase listSorteosUseCase;
    private final SorteoRestMapper mapper;

    public SorteoController(CreateSorteoUseCase createSorteoUseCase,
                            GetSorteoUseCase getSorteoUseCase,
                            ListSorteosUseCase listSorteosUseCase,
                            SorteoRestMapper mapper) {
        this.createSorteoUseCase = createSorteoUseCase;
        this.getSorteoUseCase = getSorteoUseCase;
        this.listSorteosUseCase = listSorteosUseCase;
        this.mapper = mapper;
    }

    /**
     * POST /api/sorteos
     */
    @PostMapping
    public ResponseEntity<SorteoResponse> createSorteo(@Valid @RequestBody CreateSorteoRequest request) {

        Sorteo sorteoCreado = createSorteoUseCase.execute(request.getNombre(), request.getFecha());

        SorteoResponse response = mapper.toResponse(sorteoCreado);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * GET /api/sorteos
     */
    @GetMapping
    public ResponseEntity<List<SorteoResponse>> listSorteos() {

        List<Sorteo> sorteos = listSorteosUseCase.execute();

        List<SorteoResponse> responses = sorteos.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    /**
     * GET /api/sorteos/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<SorteoResponse> getSorteo(@PathVariable Long id) {

        Sorteo sorteo = getSorteoUseCase.execute(id);

        SorteoResponse response = mapper.toResponse(sorteo);

        return ResponseEntity.ok(response);
    }
}

