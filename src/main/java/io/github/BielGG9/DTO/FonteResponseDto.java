package io.github.BielGG9.DTO;

import io.github.BielGG9.quarkus.domain.model.Certificacao;
import io.github.BielGG9.quarkus.domain.model.Fonte;

public record FonteResponseDto(
        int potencia,
        Certificacao certificacao,
        double preco,
        String marca, // Nome da marca
        Integer quantidadeEmEstoque
) {
    public static FonteResponseDto valueOf(Fonte fonte) {
        if (fonte == null) {
            return null;
        }
        if (fonte.getMarca() == null) { // Tratamento para o caso de marca ser nula na entidade
            throw new IllegalStateException("A entidade Fonte com ID " + fonte.getId() + " possui uma marca nula.");
        }
        return new FonteResponseDto(
                fonte.getPotencia(),          // int
                fonte.getCertificacao(),      // Certificacao
                fonte.getPreco(),             // double
                fonte.getMarca().getNome(),   // String
                fonte.getQuantidadeEmEstoque()// Integer
        );
    }
}