package com.konex.lottery_backend.application.service.cliente;

import com.konex.lottery_backend.domain.exception.EmailDuplicadoException;
import com.konex.lottery_backend.domain.exception.ValidationException;
import com.konex.lottery_backend.domain.model.Cliente;
import com.konex.lottery_backend.domain.port.in.cliente.CreateClienteUseCase;
import com.konex.lottery_backend.domain.port.out.ClienteRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * Servicio que implementa el caso de uso: Crear Cliente
 */
@Service
@Transactional
public class CreateClienteService implements CreateClienteUseCase {

    private final ClienteRepositoryPort clienteRepository;

    public CreateClienteService(ClienteRepositoryPort clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Ejecuta el caso de uso: crear un cliente
     */
    @Override
    public Cliente execute(String nombre, String email) {
        // 1. Validar datos de entrada
        validarDatos(nombre, email);

        // 2. Verificar email único
        if (clienteRepository.existsByEmail(email.trim().toLowerCase())) {
            throw new EmailDuplicadoException(email);
        }

        // 3. Crear entidad de dominio
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre.trim());
        cliente.setEmail(email.trim().toLowerCase());
        cliente.setFechaRegistro(LocalDate.now());

        // 4. Validar con el método del dominio
        if (!cliente.isValido()) {
            throw new ValidationException("El cliente no es válido");
        }

        Cliente clienteGuardado = clienteRepository.save(cliente);
        return clienteGuardado;
    }

    /**
     * Valida las reglas de negocio para crear un cliente
     */
    private void validarDatos(String nombre, String email) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ValidationException("nombre", "El nombre del cliente es obligatorio");
        }

        if (nombre.trim().length() < 2) {
            throw new ValidationException("nombre", "El nombre debe tener al menos 2 caracteres");
        }

        if (nombre.trim().length() > 100) {
            throw new ValidationException("nombre", "El nombre no puede exceder 100 caracteres");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new ValidationException("email", "El email es obligatorio");
        }

        Cliente clienteTemp = new Cliente();
        clienteTemp.setEmail(email.trim());
        if (!clienteTemp.tieneEmailValido()) {
            throw new ValidationException("email", "El formato del email no es válido");
        }
    }
}