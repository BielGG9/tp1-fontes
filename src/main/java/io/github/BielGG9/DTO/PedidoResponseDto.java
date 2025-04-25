package io.github.BielGG9.DTO;

import io.github.BielGG9.quarkus.domain.model.Pedido;
import java.time.LocalDate;

public record PedidoResponseDto(
        Long id,
        Long idCliente,
        double valorTotal,
        LocalDate data,
        String status) {

    public static PedidoResponseDto valueOf(Pedido p) {
        return new PedidoResponseDto(
                p.getId(),
                p.getCliente().getId(),
                p.getValorTotal(),
                p.getData(),
                p.getStatus()
        );
    }
}
