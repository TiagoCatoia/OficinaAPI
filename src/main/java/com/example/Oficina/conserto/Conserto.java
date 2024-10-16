package com.example.Oficina.conserto;

import com.example.Oficina.mecanico.Mecanico;
import com.example.Oficina.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "conserto")
@Entity(name = "Conserto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data_entrada;
    private String data_saida;

    @Embedded
    private Mecanico mecanico_responsavel;

    @Embedded
    private Veiculo veiculo;

    public Conserto(ConsertoDTO consertoDTO) {
        this.data_entrada = consertoDTO.data_entrada();
        this.data_saida = consertoDTO.data_saida();
        this.mecanico_responsavel = new Mecanico(consertoDTO.mecanico_responsavel());
        this.veiculo = new Veiculo(consertoDTO.veiculo());
    }
}
