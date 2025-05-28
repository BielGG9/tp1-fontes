package io.github.BielGG9.quarkus.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagamento_pix")
@DiscriminatorValue("PIX")
public class PagamentoPix extends Pagamento {

    @Column(name = "chave_pix") // Pode ser CPF/CNPJ, Email, Telefone, Chave Aleatória
    private String chavePix; // Se for QR Code estático que contém a chave

    @Column(name = "qr_code_data", length = 1000) // Para QR Code dinâmico (Copia e Cola) ou dados do QR Code estático
    private String qrCodeData;

    @Column(name = "id_transacao_pix", unique = true)
    private String idTransacaoPix; // EndToEndId ou similar

    @Column(name = "expiracao_qr_code")
    private LocalDateTime expiracaoQrCode; // Para QR Codes dinâmicos

    // Getters e Setters
    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public String getQrCodeData() {
        return qrCodeData;
    }

    public void setQrCodeData(String qrCodeData) {
        this.qrCodeData = qrCodeData;
    }

    public String getIdTransacaoPix() {
        return idTransacaoPix;
    }

    public void setIdTransacaoPix(String idTransacaoPix) {
        this.idTransacaoPix = idTransacaoPix;
    }

    public LocalDateTime getExpiracaoQrCode() {
        return expiracaoQrCode;
    }

    public void setExpiracaoQrCode(LocalDateTime expiracaoQrCode) {
        this.expiracaoQrCode = expiracaoQrCode;
    }

    @Override
    public void processarPagamento() {
        // Lógica específica para processar pagamento com Pix
        System.out.println("Processando pagamento com PIX: " + getValor());
        // Simulação: se tiver um qrCodeData, assume que foi pago
        if (qrCodeData != null && !qrCodeData.isEmpty()) {
            setStatus(StatusPagamento.APROVADO);
            setDataPagamento(LocalDate.now());
            this.idTransacaoPix = "PIX_" + System.currentTimeMillis();
        } else {
            setStatus(StatusPagamento.PENDENTE); // Aguardando pagamento
        }
    }
}