package com.br.desafio.service;

import com.br.desafio.DTO.EstatisticaDTO;
import com.br.desafio.model.Transacao;
import com.br.desafio.repository.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EstatisticaService {

    private TransacaoRepository repository;
    private static final Logger log = LoggerFactory.getLogger(EstatisticaService.class);

    public EstatisticaService(TransacaoRepository repository) {
        this.repository = repository;
    }
    public EstatisticaDTO getEstatistica(//int segundos
     ){
        OffsetDateTime tempoLimite = OffsetDateTime.now().minusSeconds(60);

        List<Transacao> transacaoLista = repository.getTransacaoLista();
        log.info("Estatísticas das transações listadas do último minuto.");

        DoubleSummaryStatistics estatisticas = transacaoLista.stream()
                .filter(t -> t.getDataHora().isAfter(tempoLimite))
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();
        if (estatisticas.getCount() == 0){
            log.info("O serviço não encontrou transações no tempo configurado.");
            return new EstatisticaDTO(0L,0.0,0.0,0.0,0.0);
        }
        log.info("Estatísticas retornadas com sucesso.");
        return new EstatisticaDTO(estatisticas.getCount(), estatisticas.getSum(), estatisticas.getAverage(), estatisticas.getMin(), estatisticas.getMax());
    }
}