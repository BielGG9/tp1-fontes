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
        return fonteService.findAll(); // ✅ Chamando método correto
    }

    @POST
    public Response adicionarFonte(FonteDto fonteDto) {
        Fonte novaFonte = fonteService.create(fonteDto); // ✅ Usando DTO corretamente
        return Response.status(Response.Status.CREATED).entity(novaFonte).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Fonte fonte = fonteService.findById(id); // ✅ Chamando método correto
        return Response.ok(fonte).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removerFonte(@PathParam("id") Long id) {
        fonteService.delete(id); // ✅ Chamando método correto
        return Response.noContent().build();
    }
}
