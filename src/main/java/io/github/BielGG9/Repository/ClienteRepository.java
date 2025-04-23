package io.github.BielGG9.Repository;

import io.github.BielGG9.quarkus.domain.model.Cliente;
import io.github.BielGG9.quarkus.domain.model.Fonte;
import io.github.BielGG9.quarkus.domain.model.Marca;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;

import java.util.List;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {
        public List<Cliente> findByNome(String nome) {
            return find("nome LIKE ?1", "%" + nome + "%").list();
        }

        public List<Cliente> findByEmail(String email) {
            return find("email LIKE ?1", "%" + email + "%").list();
        }

        public List<Cliente> findByEndereco(String endereco) {
            return find("endereco LIKE ?1", "%" + endereco + "%").list();
        }

        public List<Cliente> findByTelefone(String telefone) {
        return find("telefone LIKE ?1", "%" + telefone + "%").list();
        }

    }

