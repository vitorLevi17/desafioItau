package com.br.desafio.model;

import com.br.desafio.DTO.CriarTransacaoDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TransacaoTest {


    @Test
    void deveCriarTransacao(){
        BigDecimal valorEsperado = new BigDecimal("150.50");
        OffsetDateTime dataEsperada = OffsetDateTime.of(2026, 8, 10, 10, 30, 0, 0, ZoneOffset.of("-03:00"));

        CriarTransacaoDTO dto = new CriarTransacaoDTO(valorEsperado, dataEsperada);

        Transacao transacao = new Transacao(dto);

        assertEquals(dto.valor(),transacao.getValor());
        assertEquals(dto.dataHora(),transacao.getDataHora());
    }
}