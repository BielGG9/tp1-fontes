package io.github.BielGG9.Service;

import io.github.BielGG9.DTO.FonteDto;
import io.github.BielGG9.quarkus.domain.model.Fonte;

import java.util.List;

public interface FonteService {
    Fonte create(FonteDto fonteDto);
    Fonte update(FonteDto fonteDto, long id);
    void delete(long id);
    Fonte findById(long id);
    List<Fonte> findAll();
    List<Fonte> findByNome(String marca);
}