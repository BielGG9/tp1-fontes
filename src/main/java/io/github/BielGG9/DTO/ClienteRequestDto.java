package io.github.BielGG9.DTO;

public record ClienteRequestDto(
        String nome,
        String email,
        String telefone,
        String endereco
) {
}
