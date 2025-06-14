package io.github.BielGG9.Test;

import io.github.BielGG9.DTO.FonteRequestDto;
import io.github.BielGG9.DTO.FonteResponseDto;
import io.github.BielGG9.Resource.FonteResource;
import io.github.BielGG9.Service.FonteService;
import io.github.BielGG9.quarkus.domain.model.Certificacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class FonteResourceTest {

    private FonteService service;
    private FonteResource resource;

    @BeforeEach
    public void setup() {
        service = mock(FonteService.class);
        resource = new FonteResource();
        resource.service = service;
    }

    @Test
    public void testBuscarTodos() {
        when(service.findAll()).thenReturn(Collections.emptyList());
        List<FonteResponseDto> result = resource.buscarTodos();
        assertEquals(0, result.size());
    }

    @Test
    public void testBuscarPorId() {
        FonteResponseDto dto = new FonteResponseDto(500, Certificacao.BRONZE, 300.0, "Marca", 2);
        when(service.findById(1L)).thenReturn(dto);
        FonteResponseDto result = resource.buscarPorId(1L);
        assertEquals(Certificacao.BRONZE, result.certificacao());
    }

    @Test
    public void testBuscarPorMarca() {
        when(service.findByMarca("MarcaX")).thenReturn(Collections.emptyList());
        List<FonteResponseDto> result = resource.buscarPorMarca("MarcaX");
        assertEquals(0, result.size());
    }

    @Test
    public void testBuscarPorPotencia() {
        when(service.findByPotencia(500)).thenReturn(Collections.emptyList());
        List<FonteResponseDto> result = resource.buscarPorPotencia(500);
        assertEquals(0, result.size());
    }

    @Test
    public void testBuscarPorCertificacao() {
        when(service.findByCertificacao("80 Plus Bronze")).thenReturn(Collections.emptyList());
        List<FonteResponseDto> result = resource.buscarPorCertificacao("80 Plus Bronze");
        assertEquals(0, result.size());
    }

    @Test
    public void testIncluir() {
        FonteRequestDto req = new FonteRequestDto(500, "80 Plus Bronze", 300.0, 1L, 5);
        FonteResponseDto dto = new FonteResponseDto(500, Certificacao.BRONZE, 300.0, "Pichau", 4);
        when(service.create(req)).thenReturn(dto);
        FonteResponseDto result = resource.incluir(req);
        assertEquals(Certificacao.BRONZE, result.certificacao());
    }

    @Test
    public void testAlterar() {
        FonteRequestDto req = new FonteRequestDto(600, "80 Plus Gold", 400.0, 1L, 1);
        doNothing().when(service).update(1L, req);
        resource.alterar(1L, req);
        verify(service).update(1L, req);
    }

    @Test
    public void testApagar() {
        doNothing().when(service).delete(1L);
        resource.apagar(1L);
        verify(service).delete(1L);
    }
}
