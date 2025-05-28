package io.github.BielGG9.Resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

@Path("/admin-dashboard")
@RolesAllowed("ADM") // Apenas usuários com a role ADM podem acessar
@Produces(MediaType.TEXT_PLAIN)
public class AdmResource {

    @Inject
    public SecurityContext securityContext;

    @GET
    public String getAdminDashboard() {
        return "Bem-vindo ao Dashboard de Admin, " + securityContext.getUserPrincipal().getName() + "!";
    }

    @GET
    @Path("/info")
    public String getAdminInfo() {
        return "Informações sensíveis de admin: " + securityContext.getUserPrincipal().getName() + " com roles: " + securityContext.isUserInRole("ADM");
    }
}