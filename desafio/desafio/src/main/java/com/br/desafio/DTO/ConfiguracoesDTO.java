package com.br.desafio.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

public record ConfiguracoesDTO(
        @Positive(message = "Informe um tempo positivo") int segundosEstatistica
        ) {
}
