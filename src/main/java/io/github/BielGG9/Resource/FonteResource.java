package io.github.BielGG9.Resource;

import io.github.BielGG9.DTO.FonteRequestDto;
import io.github.BielGG9.Service.FonteService;
import io.github.BielGG9.DTO.FonteResponseDto;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("fontes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FonteResource {

    @Inject
    FonteService service;

    @GET
    public List<FonteResponseDto> buscarTodos() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public FonteResponseDto buscarPorId(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @GET
    @Path("/marca/{marca}")
    public List<FonteResponseDto> buscarPorMarca(@PathParam("marca") String nomeMarca) {
        return service.findByMarca(nomeMarca);
    }


    @GET
    @Path("/potencia/{potencia}")
    public List<FonteResponseDto> buscarPorPotencia(@PathParam("potencia") int potencia) {
        return service.findByPotencia(potencia);
    }

    @GET
    @Path("/certificacao/{certificacao}")
    public List<FonteResponseDto> buscarPorCertificacao(@PathParam("certificacao") String certificacao) {
        return service.findByCertificacao(certificacao);
    }

    @POST
    public FonteResponseDto incluir(FonteRequestDto dto) {
        return service.create(dto);
    }

    @PUT
    @Path("/{id}")
    public void alterar(@PathParam("id") Long id, FonteRequestDto dto) {
        service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void apagar(@PathParam("id") Long id) {
        service.delete(id);
    }
}
