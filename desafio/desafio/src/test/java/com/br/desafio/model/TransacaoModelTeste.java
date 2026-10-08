package com.br.desafio.model;
import com.br.desafio.DTO.CriarTransacaoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

class TransacaoModelTeste {

    @Test
    void deveCriarTransacaoAPartirDoDto() {
        OffsetDateTime dataEsperada = OffsetDateTime.of(2026, 8, 10, 10, 30, 0, 0, ZoneOffset.of("-03:00"));
        CriarTransacaoDTO dto = new CriarTransacaoDTO(new BigDecimal("150.50"), dataEsperada);

        Transacao transacao = new Transacao(dto);

        Assertions.assertEquals(new BigDecimal("150.50"), transacao.getValor());
        Assertions.assertEquals(dataEsperada, transacao.getDataHora());
    }
}