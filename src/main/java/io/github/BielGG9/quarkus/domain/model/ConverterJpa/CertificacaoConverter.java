package io.github.BielGG9.quarkus.domain.model.ConverterJpa;

import io.github.BielGG9.quarkus.domain.model.Certificacao;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CertificacaoConverter implements AttributeConverter<Certificacao, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Certificacao certificacao) {
        return certificacao == null ? null : certificacao.getID();
    }

    @Override
    public Certificacao convertToEntityAttribute(Integer id) {
        return Certificacao.valueOf(id);
    }
}
