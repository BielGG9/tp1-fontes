package io.github.BielGG9.quarkus.domain.model;


import jakarta.persistence.*;

@Entity
public class ItemPedido extends DefaultEntity {

    @ManyToOne(optional = false)
    private Pedido pedido;

    @ManyToOne(optional = false)
    private Fonte fonte;

    private int quantidade;

    private double precoUnitario;

    // Getters e Setters
    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }

    public Fonte getFonte() { return fonte; }
    public void setFonte(Fonte fonte) { this.fonte = fonte; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(double precoUnitario) { this.precoUnitario = precoUnitario; }
}
