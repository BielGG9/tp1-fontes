package io.github.BielGG9.Service;

import io.github.BielGG9.DTO.FornecedorRequestDto;
import io.github.BielGG9.DTO.FornecedorResponseDto;

import java.util.List;

public interface FornecedorService {
    List<FornecedorResponseDto> listarTodos();
    FornecedorResponseDto buscarPorId(Long id);
    FornecedorResponseDto salvar(FornecedorRequestDto dto);
    FornecedorResponseDto atualizar(Long id, FornecedorRequestDto dto);
    void deletar(Long id);
}
