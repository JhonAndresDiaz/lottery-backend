package com.konex.lottery_backend.infrastructure.adapter.in.rest.controller;

import com.konex.lottery_backend.domain.model.Billete;
import com.konex.lottery_backend.domain.port.in.billete.CreateBilleteUseCase;
import com.konex.lottery_backend.domain.port.in.billete.GetBilletesUseCase;
import com.konex.lottery_backend.domain.port.in.billete.VenderBilleteUseCase;
import com.konex.lottery_backend.infrastructure.adapter.in.rest.dto.request.CreateBilleteRequest;
import com.konex.lottery_backend.infrastructure.adapter.in.rest.dto.request.VentaBilleteRequest;
import com.konex.lottery_backend.infrastructure.adapter.in.rest.dto.response.BilleteResponse;
import com.konex.lottery_backend.infrastructure.adapter.in.rest.mapper.BilleteRestMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller REST para Billetes.
 * ADAPTADOR DE ENTRADA para gestión y venta de billetes.
 */
@RestController
@RequestMapping("/api/billetes")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201"})
@Tag(name = "Billetes", description = "API para gestión y venta de billetes de lotería")
public class BilleteController {

    private final CreateBilleteUseCase createBilleteUseCase;
    private final VenderBilleteUseCase venderBilleteUseCase;
    private final GetBilletesUseCase getBilletesUseCase;
    private final BilleteRestMapper mapper;

    public BilleteController(CreateBilleteUseCase createBilleteUseCase,
                             VenderBilleteUseCase venderBilleteUseCase,
                             GetBilletesUseCase getBilletesUseCase,
                             BilleteRestMapper mapper) {
        this.createBilleteUseCase = createBilleteUseCase;
        this.venderBilleteUseCase = venderBilleteUseCase;
        this.getBilletesUseCase = getBilletesUseCase;
        this.mapper = mapper;
    }

    /**
     * POST /api/billetes
     */
    @PostMapping
    public ResponseEntity<BilleteResponse> createBillete(@Valid @RequestBody CreateBilleteRequest request) {

        Billete billeteCreado = createBilleteUseCase.execute(
                request.getNumero(),
                request.getPrecio(),
                request.getSorteoId()
        );

        BilleteResponse response = mapper.toResponse(billeteCreado);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * POST /api/billetes/vender
     */
    @PostMapping("/vender")
    public ResponseEntity<BilleteResponse> venderBillete(@Valid @RequestBody VentaBilleteRequest request) {

        Billete billeteVendido = venderBilleteUseCase.execute(
                request.getBilleteId(),
                request.getClienteId()
        );

        BilleteResponse response = mapper.toResponse(billeteVendido);

        return ResponseEntity.ok(response);
    }

    /**
     * GET /api/billetes
     */
    @GetMapping
    public ResponseEntity<List<BilleteResponse>> listBilletes() {
        List<Billete> billetes = getBilletesUseCase.getAll();

        List<BilleteResponse> responses = billetes.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    /**
     * GET /api/billetes/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<BilleteResponse> getBillete(@PathVariable Long id) {
        Billete billete = getBilletesUseCase.getById(id);
        BilleteResponse response = mapper.toResponse(billete);
        return ResponseEntity.ok(response);
    }

    /**
     * GET /api/billetes/sorteo/{sorteoId}
     */
    @GetMapping("/sorteo/{sorteoId}")
    public ResponseEntity<List<BilleteResponse>> getBilletesBySorteo(@PathVariable Long sorteoId) {
        List<Billete> billetes = getBilletesUseCase.getBySorteo(sorteoId);

        List<BilleteResponse> responses = billetes.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    /**
     * GET /api/billetes/sorteo/{sorteoId}/disponibles
     */
    @GetMapping("/sorteo/{sorteoId}/disponibles")
    public ResponseEntity<List<BilleteResponse>> getBilletesDisponibles(@PathVariable Long sorteoId) {
        List<Billete> billetes = getBilletesUseCase.getDisponiblesBySorteo(sorteoId);

        List<BilleteResponse> responses = billetes.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    /**
     * GET /api/billetes/cliente/{clienteId}
     */
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<BilleteResponse>> getBilletesByCliente(@PathVariable Long clienteId) {
        List<Billete> billetes = getBilletesUseCase.getByCliente(clienteId);

        List<BilleteResponse> responses = billetes.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }
}
