package io.github.BielGG9.Resource;

import io.github.BielGG9.DTO.FornecedorRequestDto;
import io.github.BielGG9.DTO.FornecedorResponseDto;
import io.github.BielGG9.Service.FornecedorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FornecedorResourceTest {

    private FornecedorService service;
    private FornecedorResource resource;

    @BeforeEach
    public void setup() {
        service = mock(FornecedorService.class);
        resource = new FornecedorResource();
        resource.service = service;
    }

    @Test
    public void testListarTodos() {
        when(service.listarTodos()).thenReturn(Collections.emptyList());
        List<FornecedorResponseDto> result = resource.listarTodos();
        assertEquals(0, result.size());
    }

    @Test
    public void testBuscarPorId() {
        FornecedorResponseDto dto = new FornecedorResponseDto("Fornecedor Teste", "12345678000199", "contato@email.com", "11999999999");
        when(service.buscarPorId(1L)).thenReturn(dto);
        FornecedorResponseDto result = resource.buscarPorId(1L);
        assertEquals("Fornecedor Teste", result.nome());
    }

    @Test
    public void testSalvar() {
        FornecedorRequestDto req = new FornecedorRequestDto("Fornecedor Teste", "12345678000199", "contato@email.com", "11999999999");
        FornecedorResponseDto dto = new FornecedorResponseDto("Fornecedor Teste", "12345678000199", "contato@email.com", "11999999999");
        when(service.salvar(req)).thenReturn(dto);
        FornecedorResponseDto result = resource.salvar(req);
        assertEquals("12345678000199", result.cnpj());
    }

    @Test
    public void testAtualizar() {
        FornecedorRequestDto req = new FornecedorRequestDto("Fornecedor Atualizado", "98765432000188", "email@update.com", "11888888888");
        FornecedorResponseDto dto = new FornecedorResponseDto("Fornecedor Atualizado", "98765432000188", "email@update.com", "11888888888");
        when(service.atualizar(2L, req)).thenReturn(dto);
        FornecedorResponseDto result = resource.atualizar(2L, req);
        assertEquals("Fornecedor Atualizado", result.nome());
    }

    @Test
    public void testDeletar() {
        doNothing().when(service).deletar(1L);
        resource.deletar(1L);
        verify(service).deletar(1L);
    }
}
