package io.github.BielGG9.DTO;

import io.github.BielGG9.quarkus.domain.model.Certificacao;

public record FonteDto(
         String nome,
         int potencia,
         String certificacao,
         double preco,
         int idMarca) {
    }