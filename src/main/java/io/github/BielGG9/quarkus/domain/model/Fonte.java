// Fonte.java
package io.github.BielGG9.quarkus.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fontes")
public class Fonte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Marca marca;

    private int potencia;
    private String certificacao;
    private double preco;
    private String nome;

    // Construtores
    public Fonte() {}

    public Fonte(Marca marca, int potencia, String certificacao, double preco, String nome) {
        this.marca = marca;
        this.potencia = potencia;
        this.certificacao = certificacao;
        this.preco = preco;
        this.nome = nome;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public Long getId() { return id; }
    public Marca getMarca() { return marca; }
    public int getPotencia() { return potencia; }
    public String getCertificacao() { return certificacao; }
    public double getPreco() { return preco; }

    public void setNome(String nome) { this.nome = nome; }
    public void setMarca(Marca marca) { this.marca = marca; }
    public void setPotencia(int potencia) { this.potencia = potencia; }
    public void setCertificacao(String certificacao) { this.certificacao = certificacao; }
    public void setPreco(double preco) { this.preco = preco; }
}
