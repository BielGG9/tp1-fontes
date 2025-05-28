package io.github.BielGG9.DTO;

import io.github.BielGG9.quarkus.domain.model.StatusPagamento; // Certifique-se que este enum existe
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record PagamentoResponseDto(
        Long id, // ID do Pagamento
        Long idPedido,
        BigDecimal valor,
        StatusPagamento status,
        String tipoPagamento, // Ex: "BOLETO", "CARTAO", "PIX"
        LocalDateTime dataCriacao, // Do DefaultEntity
        LocalDate dataPagamento // Quando o pagamento foi efetivado (pode ser nulo)
) {}