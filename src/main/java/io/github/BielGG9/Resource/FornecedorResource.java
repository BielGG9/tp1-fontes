package io.github.BielGG9.Resource;

import io.github.BielGG9.DTO.FornecedorRequestDto;
import io.github.BielGG9.DTO.FornecedorResponseDto;
import io.github.BielGG9.Service.FornecedorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/fornecedores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FornecedorResource {

    @Inject
    FornecedorService service;

    @GET
    public List<FornecedorResponseDto> listarTodos() {
        return service.listarTodos();
    }

    @GET
    @Path("/{id}")
    public FornecedorResponseDto buscarPorId(@PathParam("id") Long id) {
        return service.buscarPorId(id);
    }

    @POST
    public FornecedorResponseDto salvar(FornecedorRequestDto dto) {
        return service.salvar(dto);
    }

    @PUT
    @Path("/{id}")
    public FornecedorResponseDto atualizar(@PathParam("id") Long id, FornecedorRequestDto dto) {
        return service.atualizar(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void deletar(@PathParam("id") Long id) {
        service.deletar(id);
    }
}
