package com.br.desafio.model;

import com.br.desafio.DTO.CriarTransacaoDTO;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Transacao {

    private BigDecimal valor;
    private OffsetDateTime dataHora;

    public Transacao(CriarTransacaoDTO dto) {
        this.valor=dto.valor();
        this.dataHora=dto.dataHora();
    }
    public BigDecimal getValor() {
        return valor;
    }
    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
