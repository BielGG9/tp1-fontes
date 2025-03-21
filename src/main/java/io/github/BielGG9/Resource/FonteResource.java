package io.github.BielGG9.Resource;

import io.github.BielGG9.Service.FonteService;
import io.github.BielGG9.DTO.FonteDto;
import io.github.BielGG9.quarkus.domain.model.Fonte;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/fontes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FonteResource {

    @Inject
    FonteService fonteService;

    @GET
    public List<Fonte> listarFontes() {
        return fonteService.findAll();
    }

    @POST
    public Response adicionarFonte(FonteDto fonteDto) {
        Fonte novaFonte = fonteService.create(fonteDto);
        return Response.status(Response.Status.CREATED).entity(novaFonte).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarFonte(@PathParam("id") Long id, FonteDto fonteDto) {
        Fonte fonteAtualizada = fonteService.update(fonteDto, id);
        return Response.ok(fonteAtualizada).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Fonte fonte = fonteService.findById(id);
        return Response.ok(fonte).build();
    }

    @GET
    @Path("/marca/{marca}")
    public Response buscarPorMarca(@PathParam("marca") String marca) {
        List<Fonte> fontes = fonteService.findByNome(marca);
        return Response.ok(fontes).build();
    }


    @DELETE
    @Path("/{id}")
    public Response removerFonte(@PathParam("id") Long id) {
        fonteService.delete(id);
        return Response.noContent().build();
    }
}
