package com.br.desafio.service;

import com.br.desafio.DTO.CriarTransacaoDTO;
import com.br.desafio.DTO.EstatisticaDTO;
import com.br.desafio.model.Transacao;
import com.br.desafio.repository.ConfiguracoesRepository;
import com.br.desafio.repository.TransacaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collections;

@ExtendWith(MockitoExtension.class)
class EstatisticaServiceTest {

    @Mock
    private TransacaoRepository repository;

    // 1. ADICIONAMOS O MOCK DO NOVO REPOSITÓRIO
    @Mock
    private ConfiguracoesRepository configRepository;

    @InjectMocks
    private EstatisticaService service;

    @Test
    void deveRetornarZerosQuandoNaoHouverTransacoes() {
        // 2. Ensinamos o mock a retornar 60 segundos para o tempo da estatística
        Mockito.when(configRepository.getSegundosEstatistica()).thenReturn(60);

        // Unhappy path: Lista vazia
        Mockito.when(repository.getTransacaoLista()).thenReturn(Collections.emptyList());

        EstatisticaDTO stats = service.getEstatistica();

        Assertions.assertEquals(0L, stats.count());
        Assertions.assertEquals(0.0, stats.sum());
        Assertions.assertEquals(0.0, stats.avg());
        Assertions.assertEquals(0.0, stats.min());
        Assertions.assertEquals(0.0, stats.max());
    }

    @Test
    void deveCalcularEstatisticasApenasDosUltimos60Segundos() {
        // 2. Ensinamos o mock a retornar 60 segundos para o tempo da estatística
        Mockito.when(configRepository.getSegundosEstatistica()).thenReturn(60);

        // Happy e Unhappy Path combinados: Transações mistas
        Transacao velha = new Transacao(new CriarTransacaoDTO(new BigDecimal("100.0"), OffsetDateTime.now().minusSeconds(70)));
        Transacao nova1 = new Transacao(new CriarTransacaoDTO(new BigDecimal("50.0"), OffsetDateTime.now().minusSeconds(10)));
        Transacao nova2 = new Transacao(new CriarTransacaoDTO(new BigDecimal("20.0"), OffsetDateTime.now().minusSeconds(5)));

        Mockito.when(repository.getTransacaoLista()).thenReturn(Arrays.asList(velha, nova1, nova2));

        EstatisticaDTO stats = service.getEstatistica();

        // A transação "velha" (100.0) deve ser ignorada no cálculo, pois ocorreu há 70s
        Assertions.assertEquals(2L, stats.count());
        Assertions.assertEquals(70.0, stats.sum());
        Assertions.assertEquals(35.0, stats.avg());
        Assertions.assertEquals(20.0, stats.min());
        Assertions.assertEquals(50.0, stats.max());
    }
}