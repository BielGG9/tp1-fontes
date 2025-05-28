package io.github.BielGG9.quarkus.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Ou SINGLE_TABLE / TABLE_PER_CLASS dependendo da preferência
@DiscriminatorColumn(name = "TIPO_PAGAMENTO", discriminatorType = DiscriminatorType.STRING)
public abstract class Pagamento extends DefaultEntity {

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPagamento status;

    @ManyToOne
    @JoinColumn(name = "pedido_id") // Supondo que um pagamento está associado a um Pedido
    private Pedido pedido;

    // Getters e Setters
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    // Método abstrato para processamento (pode ser implementado nas subclasses)
    public abstract void processarPagamento();
}