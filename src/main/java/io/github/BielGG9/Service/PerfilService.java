package io.github.BielGG9.Service;

import io.github.BielGG9.DTO.PerfilRequestDTO;
import io.github.BielGG9.DTO.PerfilResponseDTO;


import java.util.List;

public interface PerfilService {
    PerfilResponseDTO create(PerfilRequestDTO dto);
    PerfilResponseDTO update(Long id, PerfilRequestDTO dto);
    void delete(Long id);
    PerfilResponseDTO findById(Long id);
    List<PerfilResponseDTO> findAll();
}
