package com.sistemaDePagamentos.accountservice.repository;

import com.sistemaDePagamentos.accountservice.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente, Long>  {
    boolean existsByCpf(String cpf);
}
