package io.github.BielGG9.Service;

import io.github.BielGG9.DTO.ItemPedidoRequestDto;
import io.github.BielGG9.DTO.ItemPedidoResponseDto;

import java.util.List;

public interface ItemPedidoService {
    List<ItemPedidoResponseDto> listarTodos();
    ItemPedidoResponseDto buscarPorId(Long id);
    ItemPedidoResponseDto salvar(ItemPedidoRequestDto dto);
    ItemPedidoResponseDto atualizar(Long id, ItemPedidoRequestDto dto);
    void deletar(Long id);
}