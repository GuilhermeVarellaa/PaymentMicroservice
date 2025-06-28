package com.sistemaDePagamentos.accountservice.service;


import com.sistemaDePagamentos.accountservice.dto.ContaRequest;
import com.sistemaDePagamentos.accountservice.model.Cliente;
import com.sistemaDePagamentos.accountservice.model.Conta;
import com.sistemaDePagamentos.accountservice.repository.ClienteRepository;
import com.sistemaDePagamentos.accountservice.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;

    public Conta criarConta(ContaRequest request){
        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(()-> new NoSuchElementException("Cliente não encontrado com o ID: " + request.getClienteId()));

        String numero = gerarNumeroConta();

        Conta conta = Conta.builder()
                .numero(numero)
                .tipo(request.getTipo())
                .saldo(request.getSaldo())
                .cliente(cliente)
                .build();

        return contaRepository.save(conta);
    }

    private String gerarNumeroConta(){
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

}
