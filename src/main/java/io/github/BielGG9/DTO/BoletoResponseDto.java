package io.github.BielGG9.DTO;

import io.github.BielGG9.quarkus.domain.model.StatusPagamento;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record BoletoResponseDto(
        Long id, // ID do Pagamento
        Long idPedido,
        BigDecimal valor,
        StatusPagamento status,
        // String tipoPagamento, // Removido pois o nome do DTO já especifica. Adicionar se necessário.
        LocalDateTime dataCriacao, // Do DefaultEntity
        LocalDate dataPagamento, // Quando o pagamento foi efetivado (confirmado)
        String codigoBarras,
        LocalDate dataVencimento,
        String nomePagador,
        String urlBoleto // Link para visualização/impressão do boleto
) {}