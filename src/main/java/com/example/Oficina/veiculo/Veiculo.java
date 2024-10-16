package com.example.Oficina.veiculo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private String nome_veiculo;
    private String modelo_veiculo;
    private int ano_veiculo;

    public Veiculo(VeiculoDTO veiculoDTO) {
        this.nome_veiculo = veiculoDTO.nome_veiculo();
        this.modelo_veiculo = veiculoDTO.nome_veiculo();
        this.ano_veiculo = veiculoDTO.ano_veiculo();
    }
}
