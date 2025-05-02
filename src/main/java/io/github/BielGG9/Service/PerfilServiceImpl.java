package io.github.BielGG9.Service;

import io.github.BielGG9.DTO.PerfilRequestDTO;
import io.github.BielGG9.DTO.PerfilResponseDTO;
import io.github.BielGG9.Repository.PerfilRepository;
import io.github.BielGG9.quarkus.domain.model.Perfil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PerfilServiceImpl implements PerfilService {

    private final PerfilRepository repository;

    public PerfilServiceImpl(PerfilRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public PerfilResponseDTO create(PerfilRequestDTO dto) {
        Perfil perfil = new Perfil();
        perfil.setDescricao(dto.getDescricao());
        repository.persist(perfil);
        return new PerfilResponseDTO(perfil);
    }

    @Override
    @Transactional
    public PerfilResponseDTO update(Long id, PerfilRequestDTO dto) {
        Perfil perfil = repository.findById(id);
        if (perfil == null) throw new RuntimeException("Perfil não encontrado");
        perfil.setDescricao(dto.getDescricao());
        return new PerfilResponseDTO(perfil);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Perfil perfil = repository.findById(id);
        if (perfil == null) throw new RuntimeException("Perfil não encontrado");
        repository.delete(perfil);
    }

    @Override
    public PerfilResponseDTO findById(Long id) {
        Perfil perfil = repository.findById(id);
        if (perfil == null) throw new RuntimeException("Perfil não encontrado");
        return new PerfilResponseDTO(perfil);
    }

    @Override
    public List<PerfilResponseDTO> findAll() {
        return repository.listAll()
                .stream()
                .map(PerfilResponseDTO::new)
                .collect(Collectors.toList());
    }
}
