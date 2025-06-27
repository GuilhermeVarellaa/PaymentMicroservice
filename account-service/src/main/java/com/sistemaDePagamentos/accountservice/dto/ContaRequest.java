package com.sistemaDePagamentos.accountservice.dto;

import com.sistemaDePagamentos.accountservice.model.TipoConta;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaRequest {
    @NotNull(message = "O tipo da conta é obrigatório")
    private TipoConta tipo;

    @NotNull
    @DecimalMin(value = "0.00", inclusive = true, message = "O saldo inicial não pode ser negativo!")
    private BigDecimal saldo;

    @NotNull(message = "ID do cliente é obrigatório")
    private Long clienteId;
}
