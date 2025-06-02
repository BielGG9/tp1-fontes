package io.github.BielGG9.quarkus.domain.model;

import io.github.BielGG9.quarkus.domain.model.ConverterJpa.CertificacaoConverter; // Seu import
import jakarta.persistence.*;
import java.util.List; // Seu import

@Entity
public class Fonte extends DefaultEntity {

    @Column(nullable = false)
    private int potencia; // Deve retornar int

    @Column(nullable = false)
    private double preco; // Deve retornar double

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca; // marca.getNome() deve retornar String

    @Convert(converter = CertificacaoConverter.class)
    private Certificacao certificacao; // Deve retornar Certificacao

    @ManyToMany
    @JoinTable(
            name = "fonte_fornecedor",
            joinColumns = @JoinColumn(name = "fonte_id"),
            inverseJoinColumns = @JoinColumn(name = "fornecedor_id")
    )
    private List<Fornecedor> fornecedores;

    @Column(name = "quantidade_estoque", nullable = false) // Campo adicionado para estoque
    private Integer quantidadeEmEstoque; // Deve retornar Integer

    public Fonte() {}

    // Getters existentes
    public int getPotencia() { return potencia; }
    public double getPreco() { return preco; }
    public Marca getMarca() { return marca; }
    public Certificacao getCertificacao() { return certificacao; }
    public List<Fornecedor> getFornecedores() { return fornecedores; }

    // Setter para quantidadeEmEstoque (e outros setters)
    public Integer getQuantidadeEmEstoque() { return quantidadeEmEstoque; }
    public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) { this.quantidadeEmEstoque = quantidadeEmEstoque; }

    // Outros Setters...
    public void setMarca(Marca marca) { this.marca = marca; }
    public void setPotencia(int potencia) { this.potencia = potencia; }
    public void setCertificacao(Certificacao certificacao) { this.certificacao = certificacao; }
    public void setPreco(double preco) { this.preco = preco; }
    public void setFornecedores(List<Fornecedor> fornecedores) { this.fornecedores = fornecedores; }
}