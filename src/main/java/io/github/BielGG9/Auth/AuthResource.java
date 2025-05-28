package io.github.BielGG9.Auth;


import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import io.smallrye.jwt.build.Jwt;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.time.Duration;

// O restante do seu código AuthResource.java
@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    UserRepository userRepository;

    @POST
    @Path("/login")
    public Response login(Credentials credentials) {
        return userRepository.findByUsername(credentials.username)
                .filter(user -> user.password.equals(credentials.password))
                .map(user -> {
                    String token = Jwt.issuer("https://my-quarkus-jwt.com")
                            .upn(user.username)
                            .groups(user.roles)
                            .expiresIn(Duration.ofHours(1))
                            .issuedAt(Instant.now())
                            .sign();
                    return Response.ok(new TokenResponse(token)).build();
                })
                .orElse(Response.status(Response.Status.UNAUTHORIZED).entity("Credenciais inválidas").build());
    }

    public static class Credentials {
        public String username;
        public String password;
    }

    public static class TokenResponse {
        public String token;

        public TokenResponse(String token) {
            this.token = token;
        }
    }
}
