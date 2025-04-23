package io.github.BielGG9.Service;

import io.github.BielGG9.DTO.ClienteRequestDto;
import io.github.BielGG9.DTO.ClienteResponseDto;
import io.github.BielGG9.Repository.ClienteRepository;
import io.github.BielGG9.quarkus.domain.model.Cliente;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClienteResponseDto> listarTodos() {
        return repository.listAll().stream().map(ClienteResponseDto::valueOf).toList();
    }

    @Override
    public ClienteResponseDto buscarPorId(Long id) {
        return repository.findByIdOptional(id)
                .map(ClienteResponseDto::valueOf)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
    }

    @Transactional
    @Override
    public ClienteResponseDto salvar(ClienteRequestDto dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());
        cliente.setEndereco(dto.endereco());
        repository.persist(cliente);
        return ClienteResponseDto.valueOf(cliente);
    }

    @Transactional
    @Override
    public ClienteResponseDto atualizar(Long id, ClienteRequestDto dto) {
        Cliente cliente = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());
        cliente.setEndereco(dto.endereco());
        return ClienteResponseDto.valueOf(cliente);
    }

    @Transactional
    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
