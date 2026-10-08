package com.br.desafio.repository;

import com.br.desafio.DTO.CriarTransacaoDTO;
import com.br.desafio.model.Transacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

class TransacaoRepositoryTest {

    private TransacaoRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TransacaoRepository();
    }

    @Test
    void deveSalvarTransacaoEIncrementarLista() {
        Transacao transacao = new Transacao(new CriarTransacaoDTO(new BigDecimal("10.0"), OffsetDateTime.now()));
        repository.salvarTransacao(transacao);

        Assertions.assertEquals(1, repository.getTransacaoLista().size());
    }

    @Test
    void deveZerarTodasAsTransacoes() {
        repository.salvarTransacao(new Transacao(new CriarTransacaoDTO(new BigDecimal("10.0"), OffsetDateTime.now())));
        repository.zerarTransacaoLista();

        Assertions.assertTrue(repository.getTransacaoLista().isEmpty());
    }
}