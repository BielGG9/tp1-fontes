package io.github.BielGG9.Auth;

import java.util.Set;

public class User {
    public String username;
    public String password; // Em um projeto real, use hashing de senha
    public Set<String> roles;

    public User(String username, String password, Set<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}