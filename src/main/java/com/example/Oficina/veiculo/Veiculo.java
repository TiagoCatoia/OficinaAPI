package com.example.Oficina.veiculo;

import com.example.Oficina.mecanico.Mecanico;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    @NotNull(message = "Nome do veículo é obrigatório")
    @NotBlank(message = "Nome do veículo é obrigatório")
    private String nome_veiculo;
    private String modelo_veiculo;
    private int ano_veiculo;
}
