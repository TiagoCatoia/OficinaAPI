package com.example.Oficina.repository;

import com.example.Oficina.conserto.Conserto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
    Page<Conserto> findAllConsertoByAtivoTrue(Pageable paginacao);
    Optional<Conserto> findByIdAndAtivoTrue(Long id);
}
