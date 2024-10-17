package com.example.Oficina.mecanico;

import jakarta.validation.constraints.NotBlank;

public record MecanicoDTO(
    @NotBlank(message = "Nome do mecânico é obrigatório")
    String nome_mecanico,
    int anos_experiencia_mecanico
) {
    public MecanicoDTO(Mecanico mecanico) {
        this(mecanico.getNome_mecanico(), mecanico.getAnos_experiencia_mecanico());
    }
}
