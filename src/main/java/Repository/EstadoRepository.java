package Repository;

import io.github.BielGG9.quarkus.domain.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import static java.nio.file.Files.find;

@ApplicationScoped
public class EstadoRepository implements PanacheRepository<Estado> {

    public Estado findBySigla(String sigla) {
        return find("Select e From Estado Where e.sigla = ?", sigla).firstResult();
    }
}
