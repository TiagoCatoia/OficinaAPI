package com.example.Oficina.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VeiculoDTO(
        @NotBlank(message = "Nome do veículo é obrigatório")
        String nome_veiculo,
        @NotBlank(message = "Modelo do veículo é obrigatório")
        String modelo_veiculo,
        @Pattern(regexp = "\\d{4}", message = "Ano não está no formato: yyyy")
        String ano_veiculo,
        String cor
) {
        public VeiculoDTO(Veiculo veiculo){
                this (veiculo.getNome_veiculo(), veiculo.getModelo_veiculo(),
                        String.valueOf(veiculo.getAno_veiculo()), veiculo.getCor());
        }
}
