package io.github.BielGG9.Repository;

import io.github.BielGG9.quarkus.domain.model.Marca;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class MarcaRepository implements PanacheRepository<Marca> {

    public List<Marca> findByNome(String nome) {
        return find("SELECT m FROM Marca m WHERE m.nome LIKE ?1 ", "%" + nome + "%").list();
    }
}
