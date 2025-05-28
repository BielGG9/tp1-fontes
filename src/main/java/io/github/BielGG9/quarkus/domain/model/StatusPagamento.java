package io.github.BielGG9.quarkus.domain.model;

public enum StatusPagamento {
    PENDENTE("Pendente"),
    PROCESSANDO("Processando"),
    APROVADO("Aprovado"),
    REPROVADO("Reprovado"),
    CANCELADO("Cancelado");

    private final String descricao;

    StatusPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}