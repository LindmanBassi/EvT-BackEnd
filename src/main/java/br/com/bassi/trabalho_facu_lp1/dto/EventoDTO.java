package br.com.bassi.trabalho_facu_lp1.dto;

import br.com.bassi.trabalho_facu_lp1.domain.enuns.EnumEstadoEvento;
import br.com.bassi.trabalho_facu_lp1.domain.enuns.EnumTipoEvento;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record EventoDTO(

        Long localId,

        @NotBlank(message = "O evento precisa ter algum estado")
        EnumEstadoEvento estadoEvento,

        @NotBlank(message = "O evento precisa ter um tipo")
        EnumTipoEvento tipoEvento,

        @NotBlank(message = "O evento precisa ter uma data")
        Date data,

        @NotBlank(message = "O evento precisa de um título")
        String titulo,

        @NotBlank(message = "O evento precisa de uma descrição")
        String descricao,

        @NotBlank(message = "O evento precisa ter uma quantidade de vagas")
        int vagas,

        Long palestranteId) {
}
