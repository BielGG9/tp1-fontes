package io.github.BielGG9.Service;

import io.github.BielGG9.DTO.FonteRequestDto;
import io.github.BielGG9.DTO.FonteResponseDto;
import io.github.BielGG9.Repository.FonteRepository;
import io.github.BielGG9.Repository.MarcaRepository;
import io.github.BielGG9.quarkus.domain.model.Certificacao;
import io.github.BielGG9.quarkus.domain.model.Fonte;
import io.github.BielGG9.quarkus.domain.model.Marca;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class FonteServiceImpl implements FonteService {

    @Inject
    FonteRepository fonteRepository;

    @Inject
    MarcaRepository marcaRepository;

    @Override
    @Transactional
    public FonteResponseDto create(FonteRequestDto fonteDTO) {
        Marca marca = marcaRepository.findById(fonteDTO.idMarca()); // Não precisa de Long.valueOf() se idMarca já é Long
        if (marca == null) {
            throw new IllegalArgumentException("Marca com ID " + fonteDTO.idMarca() + " não encontrada.");
        }

        Fonte novaFonte = new Fonte();
        novaFonte.setPotencia(fonteDTO.potencia());
        novaFonte.setCertificacao(Certificacao.valueOf(fonteDTO.certificacao().toUpperCase()));
        novaFonte.setPreco(fonteDTO.preco());
        novaFonte.setMarca(marca);
        novaFonte.setQuantidadeEmEstoque(fonteDTO.quantidadeEmEstoque()); // <-- ADICIONADO AQUI

        fonteRepository.persist(novaFonte);
        return FonteResponseDto.valueOf(novaFonte);
    }

    @Override
    @Transactional
    public void update(long id, FonteRequestDto fonteDTO) {
        Fonte fonteEditada = fonteRepository.findById(id);
        if (fonteEditada == null) {
            throw new IllegalArgumentException("Fonte com ID " + id + " não encontrada.");
        }

        Marca marca = marcaRepository.findById(fonteDTO.idMarca()); // Não precisa de Long.valueOf() se idMarca já é Long
        if (marca == null) {
            throw new IllegalArgumentException("Marca com ID " + fonteDTO.idMarca() + " não encontrada.");
        }

        fonteEditada.setPotencia(fonteDTO.potencia());
        fonteEditada.setCertificacao(Certificacao.valueOf(fonteDTO.certificacao().toUpperCase()));
        fonteEditada.setPreco(fonteDTO.preco());
        fonteEditada.setMarca(marca);
        fonteEditada.setQuantidadeEmEstoque(fonteDTO.quantidadeEmEstoque()); // <-- ADICIONADO AQUI

        // fonteRepository.persist(fonteEditada); // Com Panache, se a entidade estiver gerenciada e dentro de uma transação, a atualização é feita no commit.
        // Se não estiver explícito, pode ser bom adicionar para clareza ou se houver problemas.
    }

    @Override
    @Transactional
    public void delete(long id) {
        boolean deleted = fonteRepository.deleteById(id);
        if (!deleted) {
            throw new IllegalArgumentException("Fonte com ID " + id + " não encontrada.");
        }
    }

    @Override
    public FonteResponseDto findById(long id) {
        Fonte fonte = fonteRepository.findById(id);
        if (fonte == null) {
            throw new IllegalArgumentException("Fonte com ID " + id + " não encontrada.");
        }
        return FonteResponseDto.valueOf(fonte);
    }

    @Override
    public List<FonteResponseDto> findByMarca(String nomeMarca) {
        // Ajuste na query para buscar pelo nome da marca, não pelo ID
        List<Marca> marcas = marcaRepository.find("nome", nomeMarca).list();
        if (marcas.isEmpty()) {
            throw new IllegalArgumentException("Marca com nome " + nomeMarca + " não encontrada.");
        }
        // Se puder haver múltiplas marcas com o mesmo nome (improvável para nome exato),
        // você precisará decidir como lidar com isso. Assumindo que nome da marca é único ou pegamos a primeira.
        Marca marca = marcas.get(0);

        return fonteRepository.find("marca", marca)
                .list()
                .stream()
                .map(FonteResponseDto::valueOf)
                .collect(Collectors.toList());
    }


    @Override
    public List<FonteResponseDto> findAll() {
        return fonteRepository.listAll()
                .stream()
                .map(FonteResponseDto::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public List<FonteResponseDto> findByCertificacao(String certificacao) {
        return fonteRepository.find("certificacao", Certificacao.valueOf(certificacao.toUpperCase()))
                .list()
                .stream()
                .map(FonteResponseDto::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public List<FonteResponseDto> findByPotencia(int potencia) {
        return fonteRepository.find("potencia", potencia)
                .list()
                .stream()
                .map(FonteResponseDto::valueOf)
                .collect(Collectors.toList());
    }
}