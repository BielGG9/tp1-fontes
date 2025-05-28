package io.github.BielGG9.DTO;

import io.github.BielGG9.quarkus.domain.model.StatusPagamento;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record PixResponseDto(
        Long id, // ID do Pagamento
        Long idPedido,
        BigDecimal valor,
        StatusPagamento status,
        // String tipoPagamento, // Removido pois o nome do DTO já especifica. Adicionar se necessário.
        LocalDateTime dataCriacao, // Do DefaultEntity
        LocalDate dataPagamento, // Quando o pagamento foi efetivado
        String qrCodeCopiaECola, // Conteúdo para o "Pix Copia e Cola"
        String imagemQrCodeBase64, // Opcional: Imagem do QR Code em Base64
        LocalDateTime dataExpiracaoQrCode,
        String idTransacaoPix // EndToEndId, preenchido após confirmação
) {}