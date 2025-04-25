package io.github.BielGG9.Service;

import io.github.BielGG9.DTO.PedidoRequestDto;
import io.github.BielGG9.DTO.PedidoResponseDto;

import java.util.List;

public interface PedidoService {
    List<PedidoResponseDto> listarTodos();
    PedidoResponseDto buscarPorId(Long id);
    PedidoResponseDto salvar(PedidoRequestDto dto);
    PedidoResponseDto atualizar(Long id, PedidoRequestDto dto);
    void deletar(Long id);
}