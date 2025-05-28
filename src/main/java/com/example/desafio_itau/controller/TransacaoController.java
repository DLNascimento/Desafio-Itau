package com.example.desafio_itau.controller;

import com.example.desafio_itau.dto.TransacaoDto;
import com.example.desafio_itau.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }


    @PostMapping
    public ResponseEntity<Void> criandoTransacao(@Valid @RequestBody TransacaoDto transacaoDto) {
        transacaoService.adicionarTransacao(transacaoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletandoTransacao() {
        transacaoService.deletandoTransacoes();
        return ResponseEntity.ok().build();
    }
}
