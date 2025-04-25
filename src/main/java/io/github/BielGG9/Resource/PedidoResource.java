package io.github.BielGG9.Resource;


import io.github.BielGG9.DTO.PedidoRequestDto;
import io.github.BielGG9.DTO.PedidoResponseDto;
import io.github.BielGG9.Service.PedidoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @Inject
    PedidoService service;

    @GET
    public List<PedidoResponseDto> listarTodos() {
        return service.listarTodos();
    }

    @GET
    @Path("/{id}")
    public PedidoResponseDto buscarPorId(@PathParam("id") Long id) {
        return service.buscarPorId(id);
    }

    @POST
    public PedidoResponseDto salvar(PedidoRequestDto dto) {
        return service.salvar(dto);
    }

    @PUT
    @Path("/{id}")
    public PedidoResponseDto atualizar(@PathParam("id") Long id, PedidoRequestDto dto) {
        return service.atualizar(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void deletar(@PathParam("id") Long id) {
        service.deletar(id);
    }
}
