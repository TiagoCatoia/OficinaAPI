package com.example.Oficina.controller;

import com.example.Oficina.conserto.Conserto;
import com.example.Oficina.conserto.ConsertoDTO;
import com.example.Oficina.conserto.DadosAtualizacaoConserto;
import com.example.Oficina.conserto.DetalhesConsertoDTO;
import com.example.Oficina.repository.ConsertoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity<ConsertoDTO> criarConserto(@RequestBody @Valid ConsertoDTO dados, UriComponentsBuilder uriBuilder) {
        var conserto = new Conserto(dados);
        repository.save(conserto);
        var uri = uriBuilder.path("/conserto/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body( new ConsertoDTO(conserto) );
    }

    @GetMapping
    public ResponseEntity<Page<ConsertoDTO>> listarConsertos(Pageable paginacao) {
        return ResponseEntity.ok(repository.findAllConsertoByAtivoTrue(paginacao)
                .map(ConsertoDTO::new));
    }

    @GetMapping("/detalhes")
    public ResponseEntity<Page<DetalhesConsertoDTO>> listarDetalhesConsertos(Pageable paginacao) {
        return ResponseEntity.ok(
                repository.findAllConsertoByAtivoTrue(paginacao).map(
                        DetalhesConsertoDTO::new
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listarConserto(@PathVariable(value = "id") Long id, Pageable paginacao) {
        Optional<Conserto> optionalConserto = repository.findByIdAndAtivoTrue(id);
        if (optionalConserto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ConsertoDTO(optionalConserto.get()));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarConserto(@PathVariable(value = "id") Long id,
                                                    @RequestBody @Valid DadosAtualizacaoConserto dados) {
        try {
            Conserto conserto = repository.getReferenceById(id);
            conserto.atualizarInformacoes(dados);
            return ResponseEntity.ok(new ConsertoDTO(conserto));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> apagarConserto(@PathVariable(value = "id") Long id) {
        try {
            Conserto conserto = repository.getReferenceById(id);
            conserto.apagar();
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
