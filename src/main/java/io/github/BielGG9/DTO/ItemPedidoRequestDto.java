package io.github.BielGG9.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ItemPedidoRequestDto(

        @NotNull(message = "O ID do pedido é obrigatório.")
        Long idPedido,

        @NotNull(message = "O ID da fonte é obrigatório.")
        Long idFonte,

        @Min(value = 1, message = "A quantidade deve ser no mínimo 1.")
        int quantidade,

        @Positive(message = "O preço unitário deve ser positivo.")
        double precoUnitario
) {}