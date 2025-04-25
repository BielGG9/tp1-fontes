package io.github.BielGG9.Service;


import io.github.BielGG9.DTO.PedidoRequestDto;
import io.github.BielGG9.DTO.PedidoResponseDto;
import io.github.BielGG9.Repository.ClienteRepository;
import io.github.BielGG9.Repository.PedidoRepository;
import io.github.BielGG9.quarkus.domain.model.Cliente;
import io.github.BielGG9.quarkus.domain.model.Pedido;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    PedidoRepository repository;

    @Inject
    ClienteRepository clienteRepository;

    @Override
    public List<PedidoResponseDto> listarTodos() {
        return repository.listAll().stream().map(PedidoResponseDto::valueOf).toList();
    }

    @Override
    public PedidoResponseDto buscarPorId(Long id) {
        return repository.findByIdOptional(id)
                .map(PedidoResponseDto::valueOf)
                .orElseThrow(() -> new NotFoundException("Pedido não encontrado"));
    }

    @Transactional
    @Override
    public PedidoResponseDto salvar(PedidoRequestDto dto) {
        Cliente cliente = clienteRepository.findByIdOptional(dto.idCliente())
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setValorTotal(dto.valorTotal());
        pedido.setData(dto.data());
        pedido.setStatus(dto.status());
        repository.persist(pedido);
        return PedidoResponseDto.valueOf(pedido);
    }

    @Transactional
    @Override
    public PedidoResponseDto atualizar(Long id, PedidoRequestDto dto) {
        Pedido pedido = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Pedido não encontrado"));
        Cliente cliente = clienteRepository.findByIdOptional(dto.idCliente())
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
        pedido.setCliente(cliente);
        pedido.setValorTotal(dto.valorTotal());
        pedido.setData(dto.data());
        pedido.setStatus(dto.status());
        return PedidoResponseDto.valueOf(pedido);
    }

    @Transactional
    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
