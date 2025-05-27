package com.example.desafio_itau.service;

import com.example.desafio_itau.dto.TransacaoDto;
import com.example.desafio_itau.exception.UnprocessableEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    private final List<TransacaoDto> listaTransacao = new ArrayList<>();


    public void adicionarTransacao(TransacaoDto transacaoDto) {
        if (transacaoDto.dataHora().isAfter(OffsetDateTime.now())) {
            throw new UnprocessableEntity("Data e hora > Data e hora atual");
        } else if (transacaoDto.valor() < 0) {
            throw new UnprocessableEntity("Valor não pode ser negativo");
        } else {
            listaTransacao.add(transacaoDto);
        }
    }

    public List<TransacaoDto> estatisticasTransacao() {
        OffsetDateTime listarEstatiscas = OffsetDateTime.now().minusSeconds(60);
        return listaTransacao.
                stream().
                filter(transacao -> transacao.dataHora().isAfter(listarEstatiscas)).toList();
    }

    public void deletandoTransacoes() {
        listaTransacao.clear();
    }

}
