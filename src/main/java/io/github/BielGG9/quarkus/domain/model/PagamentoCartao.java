package io.github.BielGG9.quarkus.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagamento_cartao")
@DiscriminatorValue("CARTAO")
public class PagamentoCartao extends Pagamento {

    @Embedded
    private Cartao cartao;

    @Enumerated(EnumType.STRING)
    @Column(name = "modalidade_cartao", nullable = false)
    private ModalidadeCartao modalidade;

    @Column(name = "numero_parcelas")
    private Integer numeroParcelas; // Apenas para crédito

    @Column(name = "id_autorizacao")
    private String idAutorizacao;

    // Getters e Setters
    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public ModalidadeCartao getModalidade() {
        return modalidade;
    }

    public void setModalidade(ModalidadeCartao modalidade) {
        this.modalidade = modalidade;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public String getIdAutorizacao() {
        return idAutorizacao;
    }

    public void setIdAutorizacao(String idAutorizacao) {
        this.idAutorizacao = idAutorizacao;
    }

    @Override
    public void processarPagamento() {
        // Lógica específica para processar pagamento com cartão
        System.out.println("Processando pagamento com cartão: " + getValor() + " em " + (numeroParcelas != null ? numeroParcelas + "x" : "1x") + " no " + modalidade.getDescricao());
        // Simulação de aprovação/reprovação
        if (getValor().compareTo(BigDecimal.ZERO) > 0) {
            setStatus(StatusPagamento.APROVADO);
            setDataPagamento(LocalDate.now());
            this.idAutorizacao = "AUT_" + System.currentTimeMillis();
        } else {
            setStatus(StatusPagamento.REPROVADO);
        }
    }
}