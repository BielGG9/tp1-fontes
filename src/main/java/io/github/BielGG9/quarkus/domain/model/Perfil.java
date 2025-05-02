package io.github.BielGG9.quarkus.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Perfil extends DefaultEntity {

    @Column(nullable = false)
    private String descricao;

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
