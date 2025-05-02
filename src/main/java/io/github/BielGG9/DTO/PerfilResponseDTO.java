package io.github.BielGG9.DTO;

import io.github.BielGG9.quarkus.domain.model.Perfil;

public class PerfilResponseDTO {
    private Long id;
    private String descricao;

    public PerfilResponseDTO() {}

    public PerfilResponseDTO(Perfil perfil) {
        this.id = perfil.getId();
        this.descricao = perfil.getDescricao();
    }

    public Long getId() { return id; }
    public String getDescricao() { return descricao; }

    public void setId(Long id) { this.id = id; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
