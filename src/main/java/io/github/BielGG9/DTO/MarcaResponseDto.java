package io.github.BielGG9.DTO;

import io.github.BielGG9.quarkus.domain.model.Marca;

public record MarcaResponseDto(
        Long id,
        String nome
) {

    public static MarcaResponseDto valueOf(Marca marca) {
        if (marca == null)
            return null;
        return new MarcaResponseDto(marca.getId(), marca.getNome());
    }

}
