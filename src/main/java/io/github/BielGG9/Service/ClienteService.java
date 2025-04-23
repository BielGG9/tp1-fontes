package io.github.BielGG9.Service;

import io.github.BielGG9.DTO.ClienteRequestDto;
import io.github.BielGG9.DTO.ClienteResponseDto;

import java.util.List;

public interface ClienteService {
    List<ClienteResponseDto> listarTodos();
    ClienteResponseDto buscarPorId(Long id);
    ClienteResponseDto salvar(ClienteRequestDto dto);
    ClienteResponseDto atualizar(Long id, ClienteRequestDto dto);
    void deletar(Long id);
}
