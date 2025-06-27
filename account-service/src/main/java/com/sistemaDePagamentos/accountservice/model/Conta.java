package com.sistemaDePagamentos.accountservice.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String numero;

    @Enumerated(EnumType.STRING)
    private TipoConta tipo;

    @NotNull
    private BigDecimal saldo;


    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
