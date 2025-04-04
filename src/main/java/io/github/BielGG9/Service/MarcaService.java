package io.github.BielGG9.Service;

import io.github.BielGG9.DTO.MarcaRequestDto;
import io.github.BielGG9.DTO.MarcaRequestDto;
import io.github.BielGG9.DTO.MarcaResponseDto;
import java.util.List;

public interface MarcaService {
    MarcaResponseDto create(MarcaRequestDto marcaDto);
    void update(long id, MarcaRequestDto marcaDto);
    void delete(long id);
    MarcaResponseDto findById(long id);
    List<MarcaResponseDto> findByNome(String nome);
    List<MarcaResponseDto> findAll();
}
