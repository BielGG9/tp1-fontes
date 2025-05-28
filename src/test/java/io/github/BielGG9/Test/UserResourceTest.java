package io.github.BielGG9.Test;

import io.github.BielGG9.Resource.UserResource;
import jakarta.ws.rs.core.SecurityContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.Principal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserResourceTest {

    private UserResource resource;
    private SecurityContext securityContext;

    @BeforeEach
    public void setup() {
        resource = new UserResource();
        securityContext = mock(SecurityContext.class);
        resource.securityContext = securityContext;  // Injeção manual para teste
    }

    @Test
    public void testGetUserProfile() {
        Principal principal = () -> "User123";
        when(securityContext.getUserPrincipal()).thenReturn(principal);

        String result = resource.getUserProfile();

        assertEquals("Bem-vindo ao seu Perfil de Usuário, User123!", result);
    }
}
