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
    private String ano_veiculo;
    private String cor;

    public Veiculo(VeiculoDTO veiculoDTO) {
        this.nome_veiculo = veiculoDTO.nome_veiculo();
        this.modelo_veiculo = veiculoDTO.modelo_veiculo();
        this.ano_veiculo = veiculoDTO.ano_veiculo();
        this.cor = veiculoDTO.cor();
    }
}
