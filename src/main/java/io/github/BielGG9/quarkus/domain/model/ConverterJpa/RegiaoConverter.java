package io.github.BielGG9.quarkus.domain.model.ConverterJpa;

import io.github.BielGG9.quarkus.domain.model.Marca;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RegiaoConverter implements AttributeConverter<Marca, String> {

    @Override
    public String convertToDatabaseColumn(Marca marca) {
        return (marca == null) ? null : marca.getNome();  // Armazenar o nome da região como String
    }

    @Override
    public Marca convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : Marca.valueOf(dbData);  // Converter de volta para o enum
    }
}
