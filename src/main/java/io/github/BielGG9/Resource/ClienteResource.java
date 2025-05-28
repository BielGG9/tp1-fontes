package io.github.BielGG9.Resource;

import io.github.BielGG9.DTO.ClienteRequestDto;
import io.github.BielGG9.DTO.ClienteResponseDto;
import io.github.BielGG9.Service.ClienteService;
import jakarta.annotation.security.RolesAllowed; // Importar a anotação RolesAllowed
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

    // O método setService é geralmente usado para testes de unidade e injeção manual.
    // Em um ambiente CDI/Quarkus, a injeção @Inject já cuida disso.
    public void setService(ClienteService service) {
        this.service = service;
    }

    @GET
    @RolesAllowed({"ADM", "USER"}) // Permite que ADM e USER listem todos os clientes
    public Response listarTodos() {
        List<ClienteResponseDto> lista = service.listarTodos();
        return Response.ok(lista).build(); // HTTP 200
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"ADM", "USER"}) // Permite que ADM e USER busquem cliente por ID
    public Response buscarPorId(@PathParam("id") Long id) {
        ClienteResponseDto dto = service.buscarPorId(id);
        if (dto == null) {
            return Response.status(Response.Status.NOT_FOUND).build(); // HTTP 404
        }
        return Response.ok(dto).build(); // HTTP 200
    }

    @POST
    @RolesAllowed("ADM") // Apenas ADM pode salvar (criar) novos clientes
    public Response salvar(@Valid ClienteRequestDto dto) {
        ClienteResponseDto response = service.salvar(dto);
        return Response.status(Response.Status.CREATED).entity(response).build(); // HTTP 201
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("ADM") // Apenas ADM pode atualizar clientes existentes
    public Response atualizar(@PathParam("id") Long id, @Valid ClienteRequestDto dto) {
        ClienteResponseDto atualizado = service.atualizar(id, dto);
        if (atualizado == null) {
            return Response.status(Response.Status.NOT_FOUND).build(); // HTTP 404
        }
        return Response.ok(atualizado).build(); // HTTP 200
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("ADM") // Apenas ADM pode deletar clientes
    public Response deletar(@PathParam("id") Long id) {
        service.deletar(id);
        return Response.noContent().build(); // HTTP 204
    }
}
