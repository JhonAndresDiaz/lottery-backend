package com.konex.lottery_backend.application.service.billete;

import com.konex.lottery_backend.domain.exception.DomainException;
import com.konex.lottery_backend.domain.exception.SorteoNotFoundException;
import com.konex.lottery_backend.domain.exception.ValidationException;
import com.konex.lottery_backend.domain.model.Billete;
import com.konex.lottery_backend.domain.model.EstadoBillete;
import com.konex.lottery_backend.domain.port.in.billete.CreateBilleteUseCase;
import com.konex.lottery_backend.domain.port.out.BilleteRepositoryPort;
import com.konex.lottery_backend.domain.port.out.SorteoRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Servicio que implementa el caso de uso: Crear Billete
 */
@Service
@Transactional
public class CreateBilleteService implements CreateBilleteUseCase {

    private final BilleteRepositoryPort billeteRepository;
    private final SorteoRepositoryPort sorteoRepository;

    public CreateBilleteService(BilleteRepositoryPort billeteRepository,
                                SorteoRepositoryPort sorteoRepository) {
        this.billeteRepository = billeteRepository;
        this.sorteoRepository = sorteoRepository;
    }

    /**
     * Ejecuta el caso de uso: crear un billete
     */
    @Override
    public Billete execute(String numero, BigDecimal precio, Long sorteoId) {
        // 1. Validar datos de entrada
        validarDatos(numero, precio, sorteoId);

        // 2. Verificar que el sorteo exista
        if (!sorteoRepository.existsById(sorteoId)) {
            throw new SorteoNotFoundException(sorteoId);
        }

        // 3. Verificar número único por sorteo
        if (billeteRepository.existsByNumeroAndSorteoId(numero.trim(), sorteoId)) {
            throw new DomainException(
                    String.format("Ya existe un billete con el número '%s' en el sorteo %d",
                            numero.trim(), sorteoId),
                    "BILLETE_NUMERO_DUPLICADO"
            );
        }

        // 4. Crear entidad de dominio
        Billete billete = new Billete();
        billete.setNumero(numero.trim());
        billete.setPrecio(precio);
        billete.setEstado(EstadoBillete.DISPONIBLE);
        billete.setSorteoId(sorteoId);
        billete.setFechaCreacion(LocalDateTime.now());

        // 5. Validar con el método del dominio
        if (!billete.isValido()) {
            throw new ValidationException("El billete no es válido");
        }

        Billete billeteGuardado = billeteRepository.save(billete);
        return billeteGuardado;
    }

    /**
     * Valida las reglas de negocio para crear un billete
     */
    private void validarDatos(String numero, BigDecimal precio, Long sorteoId) {
        if (numero == null || numero.trim().isEmpty()) {
            throw new ValidationException("numero", "El número del billete es obligatorio");
        }

        if (numero.trim().length() > 20) {
            throw new ValidationException("numero", "El número no puede exceder 20 caracteres");
        }

        if (precio == null) {
            throw new ValidationException("precio", "El precio del billete es obligatorio");
        }

        if (precio.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("precio", "El precio debe ser mayor a cero");
        }

        if (sorteoId == null) {
            throw new ValidationException("sorteoId", "El ID del sorteo es obligatorio");
        }
    }
}
