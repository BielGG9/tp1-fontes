package io.github.BielGG9.Test;

import io.github.BielGG9.DTO.MarcaRequestDto;
import io.github.BielGG9.DTO.MarcaResponseDto;
import io.github.BielGG9.Resource.MarcaResource;
import io.github.BielGG9.Service.MarcaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MarcaResourceTest {

    private MarcaService service;
    private MarcaResource resource;

    @BeforeEach
    public void setup() {
        service = mock(MarcaService.class);
        resource = new MarcaResource();
        resource.service = service;
    }

    @Test
    public void testBuscarTodos() {
        when(service.findAll()).thenReturn(Collections.emptyList());
        List<MarcaResponseDto> result = resource.buscarTodos();
        assertEquals(0, result.size());
    }

    @Test
    public void testBuscarPorId() {
        MarcaResponseDto dto = new MarcaResponseDto(1L, "Nike");
        when(service.findById(1L)).thenReturn(dto);
        MarcaResponseDto result = resource.buscarPorId(1L);
        assertEquals("Nike", result.nome());
    }

    @Test
    public void testBuscarPorNome() {
        MarcaResponseDto dto = new MarcaResponseDto(2L, "Adidas");
        when(service.findByNome("Adidas")).thenReturn(List.of(dto));
        List<MarcaResponseDto> result = resource.buscarPorNome("Adidas");
        assertEquals(1, result.size());
        assertEquals("Adidas", result.get(0).nome());
    }

    @Test
    public void testIncluir() {
        MarcaRequestDto req = new MarcaRequestDto("Puma");
        MarcaResponseDto dto = new MarcaResponseDto(3L, "Puma");
        when(service.create(req)).thenReturn(dto);
        MarcaResponseDto result = resource.incluir(req);
        assertEquals("Puma", result.nome());
    }

    @Test
    public void testAlterar() {
        MarcaRequestDto req = new MarcaRequestDto("New Balance");
        doNothing().when(service).update(4L, req);
        resource.alterar(4L, req);
        verify(service).update(4L, req);
    }

    @Test
    public void testApagar() {
        doNothing().when(service).delete(5L);
        resource.apagar(5L);
        verify(service).delete(5L);
    }
}
