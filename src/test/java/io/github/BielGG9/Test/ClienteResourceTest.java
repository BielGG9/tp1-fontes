package io.github.BielGG9.Test;

import io.github.BielGG9.DTO.ClienteRequestDto;
import io.github.BielGG9.DTO.ClienteResponseDto;
import io.github.BielGG9.Resource.ClienteResource;
import io.github.BielGG9.Service.ClienteService;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ClienteResourceTest {

    private ClienteResource resource;
    private ClienteService service;

    @BeforeEach
    public void setup() {
        service = mock(ClienteService.class);
        resource = new ClienteResource();
        resource.setService(service); // Setter correto
    }

    @Test
    public void testListarTodos() {
        when(service.listarTodos()).thenReturn(java.util.Collections.emptyList());
        Response response = resource.listarTodos();
        assertEquals(200, response.getStatus());
    }

    @Test
    public void testBuscarPorIdFound() {
        ClienteResponseDto dto = new ClienteResponseDto("Nome", "email@email.com", "11999999999");
        when(service.buscarPorId(1L)).thenReturn(dto);
        Response response = resource.buscarPorId(1L);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void testBuscarPorIdNotFound() {
        when(service.buscarPorId(1L)).thenReturn(null);  // Simula não encontrado
        Response response = resource.buscarPorId(1L);
        assertEquals(404, response.getStatus());         // Espera HTTP 404
    }

    @Test
    public void testSalvar() {
        ClienteRequestDto req = new ClienteRequestDto("Nome", "email@email.com", "11999999999", "Rua A");
        ClienteResponseDto dto = new ClienteResponseDto("Nome", "email@email.com", "11999999999");
        when(service.salvar(req)).thenReturn(dto);
        Response response = resource.salvar(req);
        assertEquals(201, response.getStatus());
    }

    @Test
    public void testAtualizar() {
        ClienteRequestDto req = new ClienteRequestDto("Nome", "email@email.com", "11999999999", "Rua A");
        ClienteResponseDto dto = new ClienteResponseDto("Nome", "email@email.com", "11999999999");
        when(service.atualizar(1L, req)).thenReturn(dto);
        Response response = resource.atualizar(1L, req);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void testDeletar() {
        doNothing().when(service).deletar(1L);
        Response response = resource.deletar(1L);
        assertEquals(204, response.getStatus());
    }
}
