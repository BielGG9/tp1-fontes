package io.github.BielGG9.Test;

import io.github.BielGG9.DTO.PedidoRequestDto;
import io.github.BielGG9.DTO.PedidoResponseDto;
import io.github.BielGG9.Resource.PedidoResource;
import io.github.BielGG9.Service.PedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PedidoResourceTest {

    private PedidoService service;
    private PedidoResource resource;

    @BeforeEach
    public void setup() {
        service = mock(PedidoService.class);
        resource = new PedidoResource();
        resource.service = service;
    }

    @Test
    public void testListarTodos() {
        when(service.listarTodos()).thenReturn(Collections.emptyList());
        List<PedidoResponseDto> result = resource.listarTodos();
        assertEquals(0, result.size());
    }

    @Test
    public void testBuscarPorId() {
        PedidoResponseDto dto = new PedidoResponseDto(1L, 1L, 300.0, LocalDate.of(2024, 12, 1), "FINALIZADO");
        when(service.buscarPorId(1L)).thenReturn(dto);
        PedidoResponseDto result = resource.buscarPorId(1L);
        assertEquals("FINALIZADO", result.status());
        assertEquals(300.0, result.valorTotal());
    }

    @Test
    public void testSalvar() {
        PedidoRequestDto req = new PedidoRequestDto(1L, 500.0, LocalDate.of(2024, 12, 15), "ABERTO");
        PedidoResponseDto dto = new PedidoResponseDto(10L, 1L, 500.0, LocalDate.of(2024, 12, 15), "ABERTO");
        when(service.salvar(req)).thenReturn(dto);
        PedidoResponseDto result = resource.salvar(req);
        assertEquals(500.0, result.valorTotal());
    }

    @Test
    public void testAtualizar() {
        PedidoRequestDto req = new PedidoRequestDto(2L, 450.0, LocalDate.of(2024, 12, 20), "PAGO");
        PedidoResponseDto dto = new PedidoResponseDto(5L, 2L, 450.0, LocalDate.of(2024, 12, 20), "PAGO");
        when(service.atualizar(5L, req)).thenReturn(dto);
        PedidoResponseDto result = resource.atualizar(5L, req);
        assertEquals("PAGO", result.status());
    }

    @Test
    public void testDeletar() {
        doNothing().when(service).deletar(3L);
        resource.deletar(3L);
        verify(service).deletar(3L);
    }
}
