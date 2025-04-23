package io.github.BielGG9.Resource;

import io.github.BielGG9.DTO.ClienteRequestDto;
import io.github.BielGG9.DTO.ClienteResponseDto;
import io.github.BielGG9.Service.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    ClienteService service;

    @GET
    public List<ClienteResponseDto> listarTodos() {
        return service.listarTodos();
    }

    @GET
    @Path("/{id}")
    public ClienteResponseDto buscarPorId(@PathParam("id") Long id) {
        return service.buscarPorId(id);
    }

    @POST
    public ClienteResponseDto salvar(ClienteRequestDto dto) {
        return service.salvar(dto);
    }

    @PUT
    @Path("/{id}")
    public ClienteResponseDto atualizar(@PathParam("id") Long id, ClienteRequestDto dto) {
        return service.atualizar(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void deletar(@PathParam("id") Long id) {
        service.deletar(id);
    }
}
