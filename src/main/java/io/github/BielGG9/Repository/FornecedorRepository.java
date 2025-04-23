package io.github.BielGG9.Repository;

import io.github.BielGG9.quarkus.domain.model.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class FornecedorRepository implements PanacheRepository<Fornecedor> {
    public List<Fornecedor> findByNome(String nome) {
        return find("nome LIKE ?1", "%" + nome + "%").list();
    }

    public List<Fornecedor> findByCnpj(String cnpj) {
        return find("cnpj LIKE ?1", "%" + cnpj + "%").list();
    }

    public List<Fornecedor> findByEmailContato(String emailContato) {
        return find("emailContato LIKE ?1", "%" + emailContato + "%").list();
    }
    public List<Fornecedor> findByTelefone(String telefone) {
        return find("telefone LIKE ?1", "%" + telefone + "%").list();
    }
}
