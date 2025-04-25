package io.github.BielGG9.DTO;

import io.github.BielGG9.quarkus.domain.model.ItemPedido;

public record ItemPedidoResponseDto(
        Long id,
        Long idPedido,
        Long idFonte,
        int quantidade,
        double precoUnitario) {

    public static ItemPedidoResponseDto valueOf(ItemPedido i) {
        return new ItemPedidoResponseDto(
                i.getId(),
                i.getPedido().getId(),
                i.getFonte().getId(),
                i.getQuantidade(),
                i.getPrecoUnitario()
        );
    }
}