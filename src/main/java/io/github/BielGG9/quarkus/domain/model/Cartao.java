package io.github.BielGG9.quarkus.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern; // Para validações mais específicas

@Embeddable
public class Cartao {

    @NotBlank(message = "Número do cartão é obrigatório")
    @Column(name = "cartao_numero", nullable = false)
    private String numero;

    @NotBlank(message = "Nome do titular é obrigatório")
    @Column(name = "cartao_nome_titular", nullable = false)
    private String nomeTitular;

    @NotBlank(message = "Data de validade é obrigatória")
    @Pattern(regexp = "^(0[1-9]|1[0-2])\\/([0-9]{2})$", message = "Data de validade deve estar no formato MM/AA")
    @Column(name = "cartao_data_validade", nullable = false)
    private String dataValidade; // Formato MM/AA

    @NotBlank(message = "CVV é obrigatório")
    @Column(name = "cartao_cvv", nullable = false)
    private String cvv;

    // Getters e Setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
