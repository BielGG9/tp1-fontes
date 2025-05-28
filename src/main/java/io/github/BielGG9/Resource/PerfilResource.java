package io.github.BielGG9.Resource;


import io.github.BielGG9.DTO.PerfilRequestDTO;
import io.github.BielGG9.DTO.PerfilResponseDTO;
import io.github.BielGG9.Service.PerfilService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/perfis")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerfilResource {

    @Inject
    public PerfilService service;

    @POST
    public Response create(PerfilRequestDTO dto) {
        PerfilResponseDTO response = service.create(dto);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    public List<PerfilResponseDTO> listAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, PerfilRequestDTO dto) {
        return Response.ok(service.update(id, dto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
