package io.github.BielGG9.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record PedidoRequestDto(

        @NotNull(message = "O ID do cliente é obrigatório.")
        Long idCliente,

        @Positive(message = "O valor total deve ser positivo.")
        double valorTotal,

        @NotNull(message = "A data é obrigatória.")
        LocalDate data,

        @NotBlank(message = "O status é obrigatório.")
        String status
) {}