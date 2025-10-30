package br.com.bassi.trabalho_facu_lp1.dto.response;

import br.com.bassi.trabalho_facu_lp1.dto.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LocalResponseDTO(
        Long id,

        @NotBlank(message = "O nome é obrigatório.")
        String nome,

        @NotNull(message = "O endereço é obrigatório.")
        @Valid
        EnderecoDTO endereco,

        @NotNull(message = "A capacidade é obrigatória.")
        @Min(value = 1, message = "A capacidade deve ser maior que zero.")
        int capacidade
) {}
