package io.github.BielGG9.Service;

import io.github.BielGG9.Repository.FonteRepository;
import io.github.BielGG9.Repository.MarcaRepository;
import io.github.BielGG9.DTO.MarcaDto;
import io.github.BielGG9.DTO.MarcaResponseDto;
import io.github.BielGG9.quarkus.domain.model.Marca;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class MarcaServiceImpl implements MarcaService {

    @Inject
    MarcaRepository marcaRepository;

    @Override
    @Transactional
    public MarcaResponseDto create(MarcaDto marcaDto) {
        Marca novaMarca = new Marca();
        novaMarca.setNome(marcaDto.nome());

        marcaRepository.persist(novaMarca);
        return MarcaResponseDto.valueOf(novaMarca);
    }

    @Override
    @Transactional
    public void update(long id, MarcaDto marcaDto) {
        Marca marcaEditada = marcaRepository.findById(id);
        if (marcaEditada == null) {
            throw new IllegalArgumentException("Marca com ID " + id + " não encontrada.");
        }

        marcaEditada.setNome(marcaDto.nome());
    }

    @Override
    @Transactional
    public void delete(long id) {
        boolean deleted = marcaRepository.deleteById(id);
        if (!deleted) {
            throw new IllegalArgumentException("Marca com ID " + id + " não encontrada.");
        }
    }

    @Override
    public MarcaResponseDto findById(long id) {
        Marca marca = marcaRepository.findById(id);
        if (marca == null) {
            throw new IllegalArgumentException("Marca com ID " + id + " não encontrada.");
        }
        return MarcaResponseDto.valueOf(marca);
    }

    @Override
    public List<MarcaResponseDto> findByNome(String nome) {
        return marcaRepository.find("nome", nome)
                .list()
                .stream()
                .map(MarcaResponseDto::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public List<MarcaResponseDto> findAll() {
        return marcaRepository.listAll()
                .stream()
                .map(MarcaResponseDto::valueOf)
                .collect(Collectors.toList());
    }
}
