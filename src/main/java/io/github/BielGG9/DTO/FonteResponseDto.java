package io.github.BielGG9.DTO;

import io.github.BielGG9.quarkus.domain.model.Certificacao;
import io.github.BielGG9.quarkus.domain.model.Fonte;
import io.github.BielGG9.quarkus.domain.model.Marca;


public record FonteResponseDto(
        int potencia,
        Certificacao certificacao,
        double preco,
        String marca) {

    public static FonteResponseDto valueOf(Fonte fonte) {
        if (fonte == null)
            return null;
        return new FonteResponseDto(
                fonte.getPotencia(),
                fonte.getCertificacao(),
                fonte.getPreco(),
                fonte.getMarca().getNome()
        );
    }
}
