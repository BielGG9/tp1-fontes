package io.github.BielGG9.Repository;

import io.github.BielGG9.quarkus.domain.model.Perfil;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PerfilRepository implements PanacheRepository<Perfil> {
}
