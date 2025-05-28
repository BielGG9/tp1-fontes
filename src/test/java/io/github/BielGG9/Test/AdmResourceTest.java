package io.github.BielGG9.Test;

import io.github.BielGG9.Resource.AdmResource;
import jakarta.ws.rs.core.SecurityContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.Principal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AdmResourceTest {

    private AdmResource resource;
    private SecurityContext securityContext;

    @BeforeEach
    public void setup() {
        resource = new AdmResource();
        securityContext = mock(SecurityContext.class);
        resource.securityContext = securityContext;  // Injeção manual para teste
    }

    @Test
    public void testGetAdminDashboard() {
        Principal principal = () -> "AdminUser";
        when(securityContext.getUserPrincipal()).thenReturn(principal);

        String result = resource.getAdminDashboard();

        assertEquals("Bem-vindo ao Dashboard de Admin, AdminUser!", result);
    }

    @Test
    public void testGetAdminInfo() {
        Principal principal = () -> "AdminUser";
        when(securityContext.getUserPrincipal()).thenReturn(principal);
        when(securityContext.isUserInRole("ADM")).thenReturn(true);

        String result = resource.getAdminInfo();

        assertEquals("Informações sensíveis de admin: AdminUser com roles: true", result);
    }
}
