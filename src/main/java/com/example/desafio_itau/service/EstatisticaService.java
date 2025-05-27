package com.example.desafio_itau.service;

import com.example.desafio_itau.dto.EstatisticasDto;
import com.example.desafio_itau.dto.TransacaoDto;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EstatisticaService {

    TransacaoService transacaoService;

    public EstatisticaService(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    public EstatisticasDto respostaEstatisticas() {
        List<TransacaoDto> transacoes = transacaoService.estatisticasTransacao();
        DoubleSummaryStatistics estatisticaTransacoes = transacoes.stream().mapToDouble(TransacaoDto::valor).summaryStatistics();
        return new EstatisticasDto(estatisticaTransacoes.getCount(),
                estatisticaTransacoes.getAverage(),
                estatisticaTransacoes.getSum(),
                estatisticaTransacoes.getMin(),
                estatisticaTransacoes.getMax());
    }
}
