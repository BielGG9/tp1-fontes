package io.github.BielGG9.Resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

@Path("/user-profile")
@RolesAllowed({"USER", "ADM"}) // Usuários com role USER ou ADM podem acessar
@Produces(MediaType.TEXT_PLAIN)
public class UserResource {

    @Inject
    public SecurityContext securityContext;

    @GET
    public String getUserProfile() {
        return "Bem-vindo ao seu Perfil de Usuário, " + securityContext.getUserPrincipal().getName() + "!";
    }
}