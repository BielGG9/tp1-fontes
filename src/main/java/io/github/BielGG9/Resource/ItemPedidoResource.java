package io.github.BielGG9.Resource;


import io.github.BielGG9.DTO.ItemPedidoRequestDto;
import io.github.BielGG9.DTO.ItemPedidoResponseDto;
import io.github.BielGG9.Service.ItemPedidoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/itens-pedido")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemPedidoResource {

    @Inject
    public ItemPedidoService service;

    @GET
    public List<ItemPedidoResponseDto> listarTodos() {
        return service.listarTodos();
    }

    @GET
    @Path("/{id}")
    public ItemPedidoResponseDto buscarPorId(@PathParam("id") Long id) {
        return service.buscarPorId(id);
    }

    @POST
    public ItemPedidoResponseDto salvar(ItemPedidoRequestDto dto) {
        return service.salvar(dto);
    }

    @PUT
    @Path("/{id}")
    public ItemPedidoResponseDto atualizar(@PathParam("id") Long id, ItemPedidoRequestDto dto) {
        return service.atualizar(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void deletar(@PathParam("id") Long id) {
        service.deletar(id);
    }
}