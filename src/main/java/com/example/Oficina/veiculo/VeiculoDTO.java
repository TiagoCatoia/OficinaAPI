package com.example.Oficina.veiculo;

import jakarta.validation.constraints.NotBlank;


public record VeiculoDTO(
        @NotBlank(message = "Nome do veículo é obrigatório")
        String nome_veiculo,
        String modelo_veiculo,
        int ano_veiculo
) {}
