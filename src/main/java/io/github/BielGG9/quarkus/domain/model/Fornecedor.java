package io.github.BielGG9.quarkus.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
    public class Fornecedor extends DefaultEntity {

        @Column(nullable = false)
        private String nome;

        @Column(nullable = false)
        private String cnpj;

        @Column(nullable = false)
        private String emailContato;

        @Column(nullable = false)
        private String telefone;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

