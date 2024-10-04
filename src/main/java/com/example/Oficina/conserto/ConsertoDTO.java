package com.example.Oficina.conserto;

import com.example.Oficina.mecanico.Mecanico;
import com.example.Oficina.veiculo.Veiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ConsertoDTO(
        @NotNull(message = "A data de entrada é obrigatória")
        @NotBlank(message = "A data de entrada é obrigatória")
        String data_entrada,
        @NotNull(message = "Data de saída obrigatória")
        @NotBlank(message = "Data de saída obrigatória")
        String data_saida,
        @Valid
        Mecanico mecanico_responsavel,
        @Valid
        Veiculo veiculo
) { }
