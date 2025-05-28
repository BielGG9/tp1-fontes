package io.github.BielGG9.Auth;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@ApplicationScoped
public class UserRepository {

    private final Map<String, User> users = new HashMap<>();

    public UserRepository() {
        // Usuários de exemplo em memória
        users.put("admin", new User("admin", "adminpass", Set.of("ADM", "USER")));
        users.put("user", new User("user", "userpass", Set.of("USER")));
    }

    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(users.get(username));
    }
}