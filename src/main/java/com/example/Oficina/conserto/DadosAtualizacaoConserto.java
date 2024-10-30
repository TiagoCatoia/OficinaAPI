package com.example.Oficina.conserto;

import com.example.Oficina.mecanico.MecanicoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoConserto(
        Long id,
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Data não está no formato: dd/mm/yyyy")
        String data_saida,
        @NotNull(message = "Objeto mecânico é obrigatório")
        @Valid
        MecanicoDTO mecanico_responsavel
) {
    public DadosAtualizacaoConserto(Conserto conserto){
        this (
                conserto.getId(),
                conserto.getData_saida(),
                new MecanicoDTO(conserto.getMecanico_responsavel())
        );
    }
}

