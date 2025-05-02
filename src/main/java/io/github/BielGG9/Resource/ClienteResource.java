package io.github.BielGG9.Resource;

import io.github.BielGG9.DTO.ClienteRequestDto;
import io.github.BielGG9.DTO.ClienteResponseDto;
import io.github.BielGG9.Service.ClienteService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    ClienteService service;

    public void setService(ClienteService service) {
        this.service = service;
    }

    @GET
    public Response listarTodos() {
        List<ClienteResponseDto> lista = service.listarTodos();
        return Response.ok(lista).build(); // HTTP 200
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        ClienteResponseDto dto = service.buscarPorId(id);
        return Response.ok(dto).build(); // HTTP 200
    }

    @POST
    public Response salvar(@Valid ClienteRequestDto dto) {
        ClienteResponseDto response = service.salvar(dto);
        return Response.status(Response.Status.CREATED).entity(response).build(); // HTTP 201
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, @Valid ClienteRequestDto dto) {
        ClienteResponseDto atualizado = service.atualizar(id, dto);
        return Response.ok(atualizado).build(); // HTTP 200
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        service.deletar(id);
        return Response.noContent().build(); // HTTP 204
    }
}
