package com.example.Oficina.conserto;

import com.example.Oficina.mecanico.MecanicoDTO;
import com.example.Oficina.veiculo.VeiculoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ConsertoDTO(
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Data não está no formato: dd/mm/yyyy")
        String data_entrada,
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Data não está no formato: dd/mm/yyyy")
        String data_saida,
        @NotNull(message = "Objeto mecânico é obrigatório")
        @Valid
        MecanicoDTO mecanico_responsavel,
        @NotNull(message = "Objeto veículo é obrigatório")
        @Valid
        VeiculoDTO veiculo
) {
        public ConsertoDTO(Conserto conserto) {
                this(   conserto.getData_entrada(),
                        conserto.getData_saida(),
                        new MecanicoDTO(conserto.getMecanico_responsavel()),
                        new VeiculoDTO(conserto.getVeiculo())
                );
        }
}