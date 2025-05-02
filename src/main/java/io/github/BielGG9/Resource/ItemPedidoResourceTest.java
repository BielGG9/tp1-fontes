package io.github.BielGG9.Resource;

import io.github.BielGG9.DTO.ItemPedidoRequestDto;
import io.github.BielGG9.DTO.ItemPedidoResponseDto;
import io.github.BielGG9.Service.ItemPedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ItemPedidoResourceTest {

    private ItemPedidoService service;
    private ItemPedidoResource resource;

    @BeforeEach
    public void setup() {
        service = mock(ItemPedidoService.class);
        resource = new ItemPedidoResource();
        resource.service = service;
    }

    @Test
    public void testListarTodos() {
        when(service.listarTodos()).thenReturn(Collections.emptyList());
        List<ItemPedidoResponseDto> result = resource.listarTodos();
        assertEquals(0, result.size());
    }

    @Test
    public void testBuscarPorId() {
        ItemPedidoResponseDto dto = new ItemPedidoResponseDto(1L, 1L, 2L, 3, 250.0);
        when(service.buscarPorId(1L)).thenReturn(dto);
        ItemPedidoResponseDto result = resource.buscarPorId(1L);
        assertEquals(3, result.quantidade());
    }

    @Test
    public void testSalvar() {
        ItemPedidoRequestDto req = new ItemPedidoRequestDto(1L, 2L, 3, 250.0);
        ItemPedidoResponseDto dto = new ItemPedidoResponseDto(10L, 1L, 2L, 3, 250.0);
        when(service.salvar(req)).thenReturn(dto);
        ItemPedidoResponseDto result = resource.salvar(req);
        assertEquals(250.0, result.precoUnitario());
    }

    @Test
    public void testAtualizar() {
        ItemPedidoRequestDto req = new ItemPedidoRequestDto(1L, 2L, 4, 200.0);
        ItemPedidoResponseDto dto = new ItemPedidoResponseDto(15L, 1L, 2L, 4, 200.0);
        when(service.atualizar(5L, req)).thenReturn(dto);
        ItemPedidoResponseDto result = resource.atualizar(5L, req);
        assertEquals(4, result.quantidade());
    }

    @Test
    public void testDeletar() {
        doNothing().when(service).deletar(1L);
        resource.deletar(1L);
        verify(service).deletar(1L);
    }
}
