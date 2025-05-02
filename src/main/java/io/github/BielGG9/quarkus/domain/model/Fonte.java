package io.github.BielGG9.quarkus.domain.model;

import io.github.BielGG9.quarkus.domain.model.ConverterJpa.CertificacaoConverter;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Fonte extends DefaultEntity {

    @Column(nullable = false)
    private int potencia;

    @Column(nullable = false)
    private double preco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca;

    @Convert(converter = CertificacaoConverter.class)
    private Certificacao certificacao;

    @ManyToMany
    @JoinTable(
            name = "fonte_fornecedor",
            joinColumns = @JoinColumn(name = "fonte_id"),
            inverseJoinColumns = @JoinColumn(name = "fornecedor_id")
    )
    private List<Fornecedor> fornecedores;

    public Fonte() {}

    public Marca getMarca() { return marca; }
    public int getPotencia() { return potencia; }
    public Certificacao getCertificacao() { return certificacao; }
    public double getPreco() { return preco; }
    public List<Fornecedor> getFornecedores() { return fornecedores; }

    public void setMarca(Marca marca) { this.marca = marca; }
    public void setPotencia(int potencia) { this.potencia = potencia; }
    public void setCertificacao(Certificacao certificacao) { this.certificacao = certificacao; }
    public void setPreco(double preco) { this.preco = preco; }
    public void setFornecedores(List<Fornecedor> fornecedores) { this.fornecedores = fornecedores; }
}
