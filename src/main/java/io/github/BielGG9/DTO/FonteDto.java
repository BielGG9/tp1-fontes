package io.github.BielGG9.DTO;

import io.github.BielGG9.quarkus.domain.model.Certificacao;

public class FonteDto {
    private String nome;
    private int potencia;
    private String certificacao; // ✅ String recebida da requisição
    private double preco;
    private int idMarca;

    public FonteDto() {}

    public FonteDto(String nome, int potencia, String certificacao, double preco, int idMarca) {
        this.nome = nome;
        this.potencia = potencia;
        this.certificacao = certificacao;
        this.preco = preco;
        this.idMarca = idMarca;
    }

    public String getNome() { return nome; }
    public int getPotencia() { return potencia; }
    public String getCertificacao() { return certificacao; }
    public double getPreco() { return preco; }
    public int getIdMarca() { return idMarca; }

    // ✅ Converte String para Enum
    public Certificacao getCertificacaoEnum() {
        if (this.certificacao == null) return null;
        return Certificacao.valueOf(this.certificacao.toUpperCase());
    }
}
