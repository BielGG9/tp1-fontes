package io.github.BielGG9.Service;

import io.github.BielGG9.DTO.FonteDto;
import io.github.BielGG9.DTO.FonteResponseDto;

import java.util.List;

public interface FonteService {
    FonteResponseDto create(FonteDto fonteDTO);
    void update(long id, FonteDto fonteDTO);
    void delete(long id);
    FonteResponseDto findById(long id);
    List<FonteResponseDto> findByMarca(String idMarca);
    List<FonteResponseDto> findAll();
    List<FonteResponseDto> findByCertificacao(String certificacao);
    List<FonteResponseDto> findByPotencia(int potencia);
}
