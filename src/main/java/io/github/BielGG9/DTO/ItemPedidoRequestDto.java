package io.github.BielGG9.DTO;

public record ItemPedidoRequestDto(
        Long idPedido,
        Long idFonte,
        int quantidade,
        double precoUnitario) {

}