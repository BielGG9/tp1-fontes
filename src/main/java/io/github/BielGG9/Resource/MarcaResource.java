package io.github.BielGG9.Resource;

import io.github.BielGG9.DTO.MarcaRequestDto;
import io.github.BielGG9.Service.MarcaService;
import io.github.BielGG9.DTO.MarcaRequestDto;
import io.github.BielGG9.DTO.MarcaResponseDto;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("marcas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MarcaResource {

    @Inject
    MarcaService service;

    @GET
    public List<MarcaResponseDto> buscarTodos() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public MarcaResponseDto buscarPorId(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @GET
    @Path("/nome/{nome}")
    public List<MarcaResponseDto> buscarPorNome(@PathParam("nome") String nome) {
        return service.findByNome(nome);
    }

    @POST
    public MarcaResponseDto incluir(MarcaRequestDto dto) {
        return service.create(dto);
    }

    @PUT
    @Path("/{id}")
    public void alterar(@PathParam("id") Long id, MarcaRequestDto dto) {
        service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void apagar(@PathParam("id") Long id) {
        service.delete(id);
    }
}
