package com.br.desafio.repository;

import com.br.desafio.DTO.CriarTransacaoDTO;
import com.br.desafio.model.Transacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public class TransacaoTest {

    private TransacaoRepository repository;

    @BeforeEach
    void setup(){
        repository = new TransacaoRepository();
    }

    @Test
    public void deveSalvarTransacao(){
        CriarTransacaoDTO dto = new CriarTransacaoDTO(new BigDecimal("10.0"), OffsetDateTime.now().minusHours(1));
        Transacao transacao = new Transacao(dto);

        repository.salvarTransacao(transacao);

        List<Transacao> listaTotal = repository.getTransacaoLista();
        Assertions.assertEquals(1,listaTotal.size());
    }

    @Test
    public void deveLimparTransacoes(){
        CriarTransacaoDTO dto = new CriarTransacaoDTO(new BigDecimal("10.0"), OffsetDateTime.now().minusHours(1));
        Transacao transacao = new Transacao(dto);

        repository.salvarTransacao(transacao);
        List<Transacao> listaTotal = repository.getTransacaoLista();
        Assertions.assertEquals(1,listaTotal.size());

        repository.zerarTransacaoLista();
        Assertions.assertEquals(0,listaTotal.size());
    }
    @Test
    public void deveListarTodasTransacoes(){
        CriarTransacaoDTO dto = new CriarTransacaoDTO(new BigDecimal("10.0"), OffsetDateTime.now().minusHours(1));
        CriarTransacaoDTO dto2 = new CriarTransacaoDTO(new BigDecimal("100.0"), OffsetDateTime.now().minusHours(1));
        Transacao transacao = new Transacao(dto);
        Transacao transacao2 = new Transacao(dto2);

        repository.salvarTransacao(transacao);
        repository.salvarTransacao(transacao2);

        List<Transacao> listaTotal = repository.getTransacaoLista();
        Assertions.assertEquals(2,listaTotal.size());
    }
}