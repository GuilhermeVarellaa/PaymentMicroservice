package com.sistemaDePagamentos.accountservice.repository;

import com.sistemaDePagamentos.accountservice.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    boolean existsByNumero(String numero);
}
