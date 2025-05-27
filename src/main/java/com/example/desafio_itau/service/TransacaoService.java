package com.example.desafio_itau.service;

import com.example.desafio_itau.dto.TransacaoDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    private final List<TransacaoDto> listaTransacao = new ArrayList<>();


    public void adicionarTransacao(TransacaoDto transacaoDto){
        listaTransacao.add(transacaoDto);
    }


}
