package io.github.BielGG9.quarkus.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
public class DefaultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime DataCadastro;
    private LocalDateTime DataAtualizacao;

    @PrePersist
    public void registrarCadastro() {
        DataCadastro = LocalDateTime.now();

    }

    @PreUpdate
    public void atualizarCadastro() {
        DataAtualizacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.DataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return DataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.DataAtualizacao = dataAtualizacao;
    }
}
