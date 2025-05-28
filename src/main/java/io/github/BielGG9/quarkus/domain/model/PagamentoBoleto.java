package io.github.BielGG9.quarkus.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "pagamento_boleto")
@DiscriminatorValue("BOLETO")
public class PagamentoBoleto extends Pagamento {

    @Column(name = "codigo_barras", nullable = false, unique = true)
    private String codigoBarras;

    @Column(name = "data_vencimento", nullable = false)
    private LocalDate dataVencimento;

    @Column(name = "nome_pagador")
    private String nomePagador;


    // Getters e Setters
    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getNomePagador() {
        return nomePagador;
    }

    public void setNomePagador(String nomePagador) {
        this.nomePagador = nomePagador;
    }

    @Override
    public void processarPagamento() {
        // Lógica específica para processar pagamento com boleto
        System.out.println("Processando pagamento com boleto: " + getValor() + ", Vencimento: " + dataVencimento);
        // Geralmente, o boleto fica pendente até a confirmação do banco
        setStatus(StatusPagamento.PENDENTE);
        // A data de pagamento seria atualizada após a confirmação.
    }
}