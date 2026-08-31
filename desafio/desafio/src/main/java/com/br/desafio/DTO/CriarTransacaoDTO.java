package com.br.desafio.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record CriarTransacaoDTO(

        @Positive(message = "Insira um valor maior ou igual a zero")
        @NotNull(message = "Insira o valor")
        BigDecimal valor,
        @Past(message = "Informe uma data válida para transação")
        @NotNull(message = "Insira o valor")
        OffsetDateTime dataHora) {
}
