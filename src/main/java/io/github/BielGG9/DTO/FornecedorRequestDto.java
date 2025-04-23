package io.github.BielGG9.DTO;

public record FornecedorRequestDto(
        String nome,
        String cnpj,
        String emailContato,
        String telefone
) {
}
