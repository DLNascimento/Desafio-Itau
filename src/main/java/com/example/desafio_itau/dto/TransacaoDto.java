package com.example.desafio_itau.dto;

import java.time.OffsetDateTime;

public record TransacaoDto(Double valor, OffsetDateTime dataHora) {
}
