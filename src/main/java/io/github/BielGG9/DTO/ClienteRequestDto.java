package io.github.BielGG9.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClienteRequestDto(

        @NotBlank (message = "O nome é Obrigatoriório. ")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 2 e 100 caracteres. ")
        String nome,

        @NotBlank (message = "O email é Obrigatoriório. ")
        @Email(message = "Email inválido. ")
        String email,

        @NotBlank (message = "O telefone é Obrigatoriório. ")
        @Size(min = 10, max = 15, message = "O nome deve ter entre 10 e 15 dígitos. ")
        String telefone,

        @NotBlank (message = "O endereço é Obrigatoriório. ")
        String endereco
) {
    }

