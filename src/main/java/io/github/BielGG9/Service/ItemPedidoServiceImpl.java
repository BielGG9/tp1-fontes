package io.github.BielGG9.Service;

import io.github.BielGG9.DTO.ItemPedidoRequestDto;
import io.github.BielGG9.DTO.ItemPedidoResponseDto;
import io.github.BielGG9.Repository.ItemPedidoRepository;
import io.github.BielGG9.Repository.FonteRepository;
import io.github.BielGG9.Repository.PedidoRepository;
import io.github.BielGG9.quarkus.domain.model.Fonte;
import io.github.BielGG9.quarkus.domain.model.ItemPedido;
import io.github.BielGG9.quarkus.domain.model.Pedido;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class ItemPedidoServiceImpl implements ItemPedidoService {

    @Inject
    ItemPedidoRepository repository;

    @Inject
    PedidoRepository pedidoRepository;

    @Inject
    FonteRepository fonteRepository;

    @Override
    public List<ItemPedidoResponseDto> listarTodos() {
        return repository.listAll().stream().map(ItemPedidoResponseDto::valueOf).toList();
    }

    @Override
    public ItemPedidoResponseDto buscarPorId(Long id) {
        return repository.findByIdOptional(id)
                .map(ItemPedidoResponseDto::valueOf)
                .orElseThrow(() -> new NotFoundException("ItemPedido não encontrado"));
    }

    @Transactional
    @Override
    public ItemPedidoResponseDto salvar(ItemPedidoRequestDto dto) {
        Pedido pedido = pedidoRepository.findByIdOptional(dto.idPedido())
                .orElseThrow(() -> new NotFoundException("Pedido não encontrado"));
        Fonte fonte = fonteRepository.findByIdOptional(dto.idFonte())
                .orElseThrow(() -> new NotFoundException("Fonte não encontrada"));

        ItemPedido item = new ItemPedido();
        item.setPedido(pedido);
        item.setFonte(fonte);
        item.setQuantidade(dto.quantidade());
        item.setPrecoUnitario(dto.precoUnitario());
        repository.persist(item);
        return ItemPedidoResponseDto.valueOf(item);
    }

    @Transactional
    @Override
    public ItemPedidoResponseDto atualizar(Long id, ItemPedidoRequestDto dto) {
        ItemPedido item = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("ItemPedido não encontrado"));

        Pedido pedido = pedidoRepository.findByIdOptional(dto.idPedido())
                .orElseThrow(() -> new NotFoundException("Pedido não encontrado"));
        Fonte fonte = fonteRepository.findByIdOptional(dto.idFonte())
                .orElseThrow(() -> new NotFoundException("Fonte não encontrada"));

        item.setPedido(pedido);
        item.setFonte(fonte);
        item.setQuantidade(dto.quantidade());
        item.setPrecoUnitario(dto.precoUnitario());
        return ItemPedidoResponseDto.valueOf(item);
    }

    @Transactional
    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
