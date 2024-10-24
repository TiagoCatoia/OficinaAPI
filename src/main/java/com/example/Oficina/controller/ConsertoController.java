package com.example.Oficina.controller;

import com.example.Oficina.conserto.Conserto;
import com.example.Oficina.conserto.ConsertoDTO;
import com.example.Oficina.conserto.DetalhesConsertoDTO;
import com.example.Oficina.mecanico.Mecanico;
import com.example.Oficina.repository.ConsertoRepository;
import com.example.Oficina.veiculo.Veiculo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    public ResponseEntity<Conserto> criarConserto(@RequestBody @Valid ConsertoDTO consertoDTO) {
        var conserto = new Conserto(consertoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(conserto));
    }

    @GetMapping
    public ResponseEntity<Page<Conserto>> listarConsertos(Pageable paginacao) {
        return ResponseEntity.status(HttpStatus.OK).body(
                repository.findAll(paginacao)
        );
    }

    @GetMapping("/detalhes")
    public ResponseEntity<List<DetalhesConsertoDTO>> listarDetalhesConsertos() {
        return ResponseEntity.status(HttpStatus.OK).body(
                repository.findAll().stream().map(c -> new DetalhesConsertoDTO(
                        c.getData_entrada(),
                        c.getData_saida(),
                        c.getMecanico_responsavel().getNome_mecanico(),
                        c.getVeiculo().getNome_veiculo(),
                        c.getVeiculo().getModelo_veiculo())
                ).toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listarConserto(@PathVariable(value = "id") Long id) {
        Optional<Conserto> optionalConserto = repository.findById(id);
        if (optionalConserto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conserto não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalConserto.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarConserto(@PathVariable(value = "id") Long id,
                                                    @RequestBody @Valid ConsertoDTO consertoDTO) {
        Optional<Conserto> optionalConserto = repository.findById(id);
        if (optionalConserto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conserto não encontrado.");
        }
        var conserto = optionalConserto.get();

        conserto.setData_entrada(consertoDTO.data_entrada());
        conserto.setData_saida(consertoDTO.data_saida());
        conserto.setMecanico_responsavel(new Mecanico(consertoDTO.mecanico_responsavel()));
        conserto.setVeiculo(new Veiculo(consertoDTO.veiculo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(conserto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> apagarConserto(@PathVariable(value = "id") Long id) {
        Optional<Conserto> optionalConserto = repository.findById(id);
        if (optionalConserto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conserto não encontrado.");
        }
        repository.delete(optionalConserto.get());
        return ResponseEntity.status(HttpStatus.OK).body("Conserto apagado com sucesso.");
    }
}
