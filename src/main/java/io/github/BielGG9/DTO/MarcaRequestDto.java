package io.github.BielGG9.DTO;

import jakarta.validation.constraints.NotBlank;

public record MarcaRequestDto(

        @NotBlank(message = "O nome da marca é obrigatório.")
        String nome
) {}