// FonteRepository.java
package io.github.BielGG9.Repository;

import io.github.BielGG9.quarkus.domain.model.Fonte;
import io.github.BielGG9.quarkus.domain.model.Marca;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class FonteRepository implements PanacheRepository<Fonte> {
    public List<Fonte> findByMarca(Marca marca) {
        return list("marca", marca);
    }

    public List<Fonte> findByPotencia(int potencia) {
        return list("potencia", potencia);
    }

    public List<Fonte> findByCertificacao(String certificacao) {
        return list("certificacao", certificacao);
    }
}
