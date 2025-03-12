// Marca.java
package io.github.BielGG9.quarkus.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.logging.Logger;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Marca {
    CORSAIR(1, "Corsair"),
    COOLER_MASTER(2, "Cooler Master"),
    EVGA(3, "EVGA"),
    THERMALTAKE(4, "Thermaltake"),
    XPG(5, "XPG");

    private final int id;
    private final String nome;
    private static final Logger LOGGER = Logger.getLogger(Marca.class.getName());

    Marca(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }

    public static Marca fromId(int id) {
        for (Marca marca : values()) {
            if (marca.getId() == id) {
                return marca;
            }
        }
        LOGGER.warning("ID inválido para Marca: " + id);
        return null;
    }
}
