package io.github.BielGG9.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record FonteRequestDto(

        @Min(value = 1, message = "A potência deve ser maior que 0.")
        int potencia,

        @NotBlank(message = "A certificação é obrigatória.")
        String certificacao,

        @Positive(message = "O preço deve ser positivo.")
        double preco,

        @NotNull(message = "O ID da marca é obrigatório.")
        Long idMarca
) {}