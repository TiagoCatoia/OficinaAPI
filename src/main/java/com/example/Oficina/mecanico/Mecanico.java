package com.example.Oficina.mecanico;

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
public class Mecanico {
    @NotNull(message = "Nome do mecânico é obrigatório")
    @NotBlank(message = "Nome do mecânico é obrigatório")
    private String nome_mecanico;
    private int anos_experiencia_mecanico;
}
