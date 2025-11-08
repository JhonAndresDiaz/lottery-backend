package com.konex.lottery_backend.application.service.sorteo;

import com.konex.lottery_backend.domain.exception.ValidationException;
import com.konex.lottery_backend.domain.model.Sorteo;
import com.konex.lottery_backend.domain.port.in.sorteo.CreateSorteoUseCase;
import com.konex.lottery_backend.domain.port.out.SorteoRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * Servicio que implementa el caso de uso: Crear Sorteo
 */
@Service
@Transactional
public class CreateSorteoService implements CreateSorteoUseCase {

    private final SorteoRepositoryPort sorteoRepository;

    /**
     * Constructor con inyección de dependencias
     * Spring inyectará la implementación del puerto OUT automáticamente
     */
    public CreateSorteoService(SorteoRepositoryPort sorteoRepository) {
        this.sorteoRepository = sorteoRepository;
    }

    /**
     * Ejecuta el caso de uso: crear un sorteo
     */
    @Override
    public Sorteo execute(String nombre, LocalDate fecha) {
        // 1. Validar datos de entrada
        validarDatos(nombre, fecha);

        // 2. Crear entidad de dominio
        Sorteo sorteo = new Sorteo();
        sorteo.setNombre(nombre.trim());
        sorteo.setFecha(fecha);
        sorteo.setFechaCreacion(LocalDate.now());

        // 3. Validación con el método del dominio
        if (!sorteo.isValido()) {
            throw new ValidationException("El sorteo no es válido");
        }

        Sorteo sorteoGuardado = sorteoRepository.save(sorteo);
        return sorteoGuardado;
    }

    /**
     * Valida las reglas de negocio para crear un sorteo
     */
    private void validarDatos(String nombre, LocalDate fecha) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ValidationException("nombre", "El nombre del sorteo es obligatorio");
        }

        if (nombre.trim().length() < 3) {
            throw new ValidationException("nombre", "El nombre debe tener al menos 3 caracteres");
        }

        if (nombre.trim().length() > 100) {
            throw new ValidationException("nombre", "El nombre no puede exceder 100 caracteres");
        }

        if (fecha == null) {
            throw new ValidationException("fecha", "La fecha del sorteo es obligatoria");
        }

        if (fecha.isBefore(LocalDate.now())) {
            throw new ValidationException("fecha",
                    "La fecha del sorteo debe ser hoy o en el futuro. No se pueden crear sorteos en el pasado");
        }
    }
}
