package io.github.BielGG9.DTO;

import io.github.BielGG9.quarkus.domain.model.Fornecedor;

public record FornecedorResponseDto(
        String nome,
        String cnpj,
        String emailContato,
        String telefone) {


    public static FornecedorResponseDto valueOf(Fornecedor fornecedor) {
        return new
        FornecedorResponseDto(fornecedor.getNome(),
                fornecedor.getCnpj(), fornecedor.getEmailContato(),
                fornecedor.getTelefone());
    }
}
