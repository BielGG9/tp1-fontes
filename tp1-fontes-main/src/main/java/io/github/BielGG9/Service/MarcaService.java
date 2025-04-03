package io.github.BielGG9.Service;

import io.github.BielGG9.DTO.MarcaDto;
import io.github.BielGG9.DTO.MarcaResponseDto;
import java.util.List;

public interface MarcaService {
    MarcaResponseDto create(MarcaDto marcaDto);
    void update(long id, MarcaDto marcaDto);
    void delete(long id);
    MarcaResponseDto findById(long id);
    List<MarcaResponseDto> findByNome(String nome);
    List<MarcaResponseDto> findAll();
}
