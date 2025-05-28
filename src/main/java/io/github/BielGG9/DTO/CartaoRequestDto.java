package io.github.BielGG9.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CartaoRequestDto(
        @NotBlank(message = "O número do cartão é obrigatório.")
        @Size(min = 13, max = 19, message = "Número do cartão inválido.") // Comprimentos comuns de cartão
        String numero,

        @NotBlank(message = "O nome do titular é obrigatório.")
        String nomeTitular,

        @NotBlank(message = "A data de validade é obrigatória.")
        @Pattern(regexp = "^(0[1-9]|1[0-2])\\/([0-9]{2})$", message = "Data de validade deve estar no formato MM/AA.")
        String dataValidade, // MM/AA

        @NotBlank(message = "O CVV é obrigatório.")
        @Size(min = 3, max = 4, message = "CVV inválido.")
        String cvv
) {}