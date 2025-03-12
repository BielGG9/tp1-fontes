// FonteDto.java
package io.github.BielGG9.DTO;

public class FonteDto {
    private String marca;
    private int potencia;
    private String certificacao;
    private double preco;
    private String nome;
    private int idMarca; // Adicionado para mapear corretamente a marca

    // Construtores
    public FonteDto() {}
    public FonteDto(String marca, int potencia, String certificacao, double preco, String nome, int idMarca) {
        this.marca = marca;
        this.potencia = potencia;
        this.certificacao = certificacao;
        this.preco = preco;
        this.nome = nome;
        this.idMarca = idMarca;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public int getPotencia() { return potencia; }
    public void setPotencia(int potencia) { this.potencia = potencia; }

    public String getCertificacao() { return certificacao; }
    public void setCertificacao(String certificacao) { this.certificacao = certificacao; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public int getIdMarca() { return idMarca; }
    public void setIdMarca(int idMarca) { this.idMarca = idMarca; }
}
