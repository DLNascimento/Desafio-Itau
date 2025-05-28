package com.example.desafio_itau.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.time.OffsetDateTime;

public record TransacaoDto(
        @NotNull Double valor,
        @NotNull OffsetDateTime dataHora) {
}
