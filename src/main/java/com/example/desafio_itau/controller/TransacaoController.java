package com.example.desafio_itau.controller;

import com.example.desafio_itau.dto.TransacaoDto;
import com.example.desafio_itau.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }


    @PostMapping
    public ResponseEntity<Void> criandoTransacao(@RequestBody TransacaoDto transacaoDto){
         transacaoService.adicionarTransacao(transacaoDto);
         return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
