package io.github.BielGG9.DTO;

import io.github.BielGG9.quarkus.domain.model.Cliente;

public record ClienteResponseDto(
        String nome,
        String email,
        String telefone
) {
    public static ClienteResponseDto valueOf(Cliente cliente) {
        if (cliente == null)
            return null;

        return new ClienteResponseDto(
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone()
        );
    }
}
