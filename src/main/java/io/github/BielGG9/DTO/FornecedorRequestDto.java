package io.github.BielGG9.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FornecedorRequestDto(

        @NotBlank(message = "O nome é obrigatório.")
        String nome,

        @NotBlank(message = "O CNPJ é obrigatório.")
        @Size(min = 14, max = 18, message = "O CNPJ deve ter entre 14 e 18 caracteres.")
        String cnpj,

        @NotBlank(message = "O e-mail de contato é obrigatório.")
        @Email(message = "Formato de e-mail inválido.")
        String emailContato,

        @NotBlank(message = "O telefone é obrigatório.")
        @Size(min = 10, max = 15, message = "O telefone deve ter entre 10 e 15 dígitos.")
        String telefone
) {}