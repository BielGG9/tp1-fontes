package io.github.BielGG9.quarkus.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.logging.Logger;

@Entity
public class Marca extends DefaultEntity {

    @Column(nullable = false, length = 100)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

