package com.example.desafio_itau.controller;

import com.example.desafio_itau.dto.EstatisticasDto;
import com.example.desafio_itau.service.EstatisticaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    EstatisticaService estatisticaService;

    public EstatisticasController(EstatisticaService estatisticaService) {
        this.estatisticaService = estatisticaService;
    }

    @GetMapping
    public ResponseEntity<EstatisticasDto> estatisticasTransacao() {
        return ResponseEntity.ok(estatisticaService.respostaEstatisticas());
    }
}
