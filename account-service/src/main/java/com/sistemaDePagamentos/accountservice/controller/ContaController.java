package com.sistemaDePagamentos.accountservice.controller;

import com.sistemaDePagamentos.accountservice.dto.ContaRequest;
import com.sistemaDePagamentos.accountservice.model.Conta;
import com.sistemaDePagamentos.accountservice.service.ContaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/contas")
public class ContaController {

    private final ContaService service;

    @PostMapping
    public ResponseEntity<Conta> criar (@Valid @RequestBody ContaRequest request){
        Conta novaConta = service.criarConta(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaConta);
    }
}
