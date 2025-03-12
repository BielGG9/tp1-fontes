package io.github.BielGG9.quarkus.domain.model;

import io.github.BielGG9.quarkus.domain.model.ConverterJpa.CertificacaoConverter;
import jakarta.persistence.*;

@Entity
@Table(name = "fontes")
public class Fonte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int potencia;
    private double preco;

    @Enumerated(EnumType.STRING)
    private Marca marca;

    @Convert(converter = CertificacaoConverter.class) // ✅ Usa o conversor para o Enum
    private Certificacao certificacao;

    public Fonte() {}

    public Fonte(Marca marca, int potencia, Certificacao certificacao, double preco, String nome) {
        this.marca = marca;
        this.potencia = potencia;
        this.certificacao = certificacao;
        this.preco = preco;
        this.nome = nome;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public Marca getMarca() { return marca; }
    public int getPotencia() { return potencia; }
    public Certificacao getCertificacao() { return certificacao; }
    public double getPreco() { return preco; }

    public void setNome(String nome) { this.nome = nome; }
    public void setMarca(Marca marca) { this.marca = marca; }
    public void setPotencia(int potencia) { this.potencia = potencia; }
    public void setCertificacao(Certificacao certificacao) { this.certificacao = certificacao; }
    public void setPreco(double preco) { this.preco = preco; }
}
