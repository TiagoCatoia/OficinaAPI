package com.example.Oficina.conserto;

import com.example.Oficina.mecanico.MecanicoDTO;
import com.example.Oficina.veiculo.VeiculoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ConsertoDTO(
        @NotBlank(message = "A data de entrada é obrigatória")
        String data_entrada,
        @NotBlank(message = "Data de saída obrigatória")
        String data_saida,
        @NotNull(message = "Nome do veículo é obrigatório")
        @Valid
        MecanicoDTO mecanico_responsavel,
        @NotNull(message = "Nome do veículo é obrigatório")
        @Valid
        VeiculoDTO veiculo
) { }
