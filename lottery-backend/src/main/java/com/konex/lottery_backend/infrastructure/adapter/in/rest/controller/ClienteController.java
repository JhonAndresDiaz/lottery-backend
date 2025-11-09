package com.konex.lottery_backend.infrastructure.adapter.in.rest.controller;

import com.konex.lottery_backend.domain.model.Cliente;
import com.konex.lottery_backend.domain.port.in.cliente.CreateClienteUseCase;
import com.konex.lottery_backend.domain.port.in.cliente.GetClienteUseCase;
import com.konex.lottery_backend.domain.port.in.cliente.ListClientesUseCase;
import com.konex.lottery_backend.infrastructure.adapter.in.rest.dto.request.CreateClienteRequest;
import com.konex.lottery_backend.infrastructure.adapter.in.rest.dto.response.ClienteResponse;
import com.konex.lottery_backend.infrastructure.adapter.in.rest.mapper.ClienteRestMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller REST para Clientes
 * ADAPTADOR DE ENTRADA para gestión de clientes
 */
@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201"})
@Tag(name = "Clientes", description = "API para gestión de clientes")
public class ClienteController {

    private final CreateClienteUseCase createClienteUseCase;
    private final GetClienteUseCase getClienteUseCase;
    private final ListClientesUseCase listClientesUseCase;
    private final ClienteRestMapper mapper;

    public ClienteController(CreateClienteUseCase createClienteUseCase,
                             GetClienteUseCase getClienteUseCase,
                             ListClientesUseCase listClientesUseCase,
                             ClienteRestMapper mapper) {
        this.createClienteUseCase = createClienteUseCase;
        this.getClienteUseCase = getClienteUseCase;
        this.listClientesUseCase = listClientesUseCase;
        this.mapper = mapper;
    }

    /**
     * POST /api/clientes
     */
    @PostMapping
    public ResponseEntity<ClienteResponse> createCliente(@Valid @RequestBody CreateClienteRequest request) {

        Cliente clienteCreado = createClienteUseCase.execute(request.getNombre(), request.getEmail());

        ClienteResponse response = mapper.toResponse(clienteCreado);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * GET /api/clientes
     */
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listClientes() {

        List<Cliente> clientes = listClientesUseCase.execute();

        List<ClienteResponse> responses = clientes.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    /**
     * GET /api/clientes/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> getCliente(@PathVariable Long id) {

        Cliente cliente = getClienteUseCase.execute(id);

        ClienteResponse response = mapper.toResponse(cliente);

        return ResponseEntity.ok(response);
    }
}

