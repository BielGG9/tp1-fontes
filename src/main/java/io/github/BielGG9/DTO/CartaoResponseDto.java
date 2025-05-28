package io.github.BielGG9.DTO;

import io.github.BielGG9.quarkus.domain.model.ModalidadeCartao;
import io.github.BielGG9.quarkus.domain.model.StatusPagamento;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record CartaoResponseDto(
        Long id, // ID do Pagamento
        Long idPedido,
        BigDecimal valor,
        StatusPagamento status,
        // String tipoPagamento, // Removido pois o nome do DTO já especifica. Adicionar se necessário.
        LocalDateTime dataCriacao, // Do DefaultEntity
        LocalDate dataPagamento, // Quando o pagamento foi efetivado
        String ultimosQuatroDigitosCartao,
        ModalidadeCartao modalidade,
        Integer numeroParcelas,
        String idAutorizacao
) {}