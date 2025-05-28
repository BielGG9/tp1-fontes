package io.github.BielGG9.quarkus.domain.model;

public enum ModalidadeCartao {
    CREDITO("Crédito"),
    DEBITO("Débito");

    private final String descricao;

    ModalidadeCartao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}