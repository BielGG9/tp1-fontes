package io.github.BielGG9.Service;

import io.github.BielGG9.Repository.FonteRepository;
import io.github.BielGG9.DTO.FonteDto;
import io.github.BielGG9.quarkus.domain.model.Certificacao;
import io.github.BielGG9.quarkus.domain.model.Fonte;
import io.github.BielGG9.quarkus.domain.model.Marca;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class FonteServiceImpl implements FonteService { // Agora implementa a interface

    @Inject
    FonteRepository fonteRepository;

    @Override
    @Transactional
    public Fonte create(FonteDto fonteDto) {
        Marca marca = Marca.fromId(fonteDto.idMarca());
        if (marca == null) {
            throw new IllegalArgumentException("Marca com ID " + fonteDto.idMarca() + " é inválida.");
        }

        // ✅ Converte a String do DTO para o Enum Certificacao
        Certificacao certificacao = Certificacao.valueOf(fonteDto.certificacao().toUpperCase());

        Fonte novaFonte = new Fonte();
        novaFonte.setNome(fonteDto.nome());
        novaFonte.setPotencia(fonteDto.potencia());
        novaFonte.setCertificacao(certificacao); // Agora recebe um Enum
        novaFonte.setPreco(fonteDto.preco());
        novaFonte.setMarca(marca);

        fonteRepository.persist(novaFonte);
        return novaFonte;
    }


    @Override
    @Transactional
    public void update(FonteDto fonteDto, long id) {
        Fonte fonteEditada = fonteRepository.findById(id);
        if (fonteEditada == null) {
            throw new IllegalArgumentException("Fonte com ID " + id + " não encontrada.");
        }

        // ✅ Converte a String para Enum antes de definir
        Certificacao certificacao = Certificacao.valueOf(fonteDto.certificacao().toUpperCase());

        fonteEditada.setNome(fonteDto.nome());
        fonteEditada.setPotencia(fonteDto.potencia());
        fonteEditada.setCertificacao(certificacao); // ✅ Agora usa um Enum corretamente
        fonteEditada.setPreco(fonteDto.preco());
        fonteEditada.setMarca(Marca.fromId(fonteDto.idMarca()));
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
    public Fonte findById(long id) {
        Fonte fonte = fonteRepository.findById(id);
        if (fonte == null) {
            throw new IllegalArgumentException("Fonte com ID " + id + " não encontrada.");
        }
        return fonte;
    }

    @Override
    public List<Fonte> findAll() {
        return fonteRepository.listAll();
    }
}
