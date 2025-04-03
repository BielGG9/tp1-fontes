package io.github.BielGG9.quarkus.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Certificacao {
    BRONZE(1, "Bronze"),
    PRATA(2, "Prata"),
    OURO(3, "Ouro"),
    PLATINA(4, "Platina");

    private final int ID;
    private final String NOME;

    private Certificacao(int id, String nome) {
        this.ID = id;
        this.NOME = nome;
    }

    public int getID() { return ID; }
    public String getNOME() { return NOME; }

    public static Certificacao valueOf(int id) {
        for (Certificacao c : Certificacao.values()) {
            if (c.getID() == id)
                return c;
        }
        return null;
    }
}
