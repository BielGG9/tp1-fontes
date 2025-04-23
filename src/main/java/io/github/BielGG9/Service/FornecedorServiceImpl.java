package io.github.BielGG9.Service;
import io.github.BielGG9.DTO.FornecedorRequestDto;
import io.github.BielGG9.DTO.FornecedorResponseDto;
import io.github.BielGG9.Repository.FornecedorRepository;
import io.github.BielGG9.quarkus.domain.model.Fornecedor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class FornecedorServiceImpl implements FornecedorService {

    @Inject
    FornecedorRepository repository;

    @Override
    public List<FornecedorResponseDto> listarTodos() {
        return repository.listAll().stream().map(FornecedorResponseDto::valueOf).toList();
    }

    @Override
    public FornecedorResponseDto buscarPorId(Long id) {
        return repository.findByIdOptional(id)
                .map(FornecedorResponseDto::valueOf)
                .orElseThrow(() -> new NotFoundException("Fornecedor não encontrado"));
    }

    @Transactional
    @Override
    public FornecedorResponseDto salvar(FornecedorRequestDto dto) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(dto.nome());
        fornecedor.setCnpj(dto.cnpj());
        fornecedor.setEmailContato(dto.emailContato());
        fornecedor.setTelefone(dto.telefone());
        repository.persist(fornecedor);
        return FornecedorResponseDto.valueOf(fornecedor);
    }

    @Transactional
    @Override
    public FornecedorResponseDto atualizar(Long id, FornecedorRequestDto dto) {
        Fornecedor fornecedor = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Fornecedor não encontrado"));
        fornecedor.setNome(dto.nome());
        fornecedor.setCnpj(dto.cnpj());
        fornecedor.setEmailContato(dto.emailContato());
        fornecedor.setTelefone(dto.telefone());
        return FornecedorResponseDto.valueOf(fornecedor);
    }

    @Transactional
    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
