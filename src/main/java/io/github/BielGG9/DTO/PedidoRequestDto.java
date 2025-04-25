package io.github.BielGG9.DTO;

import java.time.LocalDate;

public record PedidoRequestDto(
        Long idCliente,
        double valorTotal,
        LocalDate data,
        String status) {
}
