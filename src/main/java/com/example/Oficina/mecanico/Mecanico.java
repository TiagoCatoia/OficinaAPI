package com.example.Oficina.mecanico;

import com.example.Oficina.conserto.DadosAtualizacaoConserto;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome_mecanico;
    private int anos_experiencia_mecanico;

    public Mecanico(MecanicoDTO mecanicoDTO) {
        this.nome_mecanico = mecanicoDTO.nome_mecanico();
        this.anos_experiencia_mecanico = mecanicoDTO.anos_experiencia_mecanico();
    }

    public void atualizarInformacoes(MecanicoDTO mecanicoDTO) {
        if (mecanicoDTO.nome_mecanico() != null) {
            this.nome_mecanico = mecanicoDTO.nome_mecanico();
        }
        if (mecanicoDTO.anos_experiencia_mecanico() >= 0) {
            this.anos_experiencia_mecanico = mecanicoDTO.anos_experiencia_mecanico();
        }
    }
}
