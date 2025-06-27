package com.sistemaDePagamentos.accountservice.controller;


import com.sistemaDePagamentos.accountservice.dto.ClienteRequest;
import com.sistemaDePagamentos.accountservice.model.Cliente;
import com.sistemaDePagamentos.accountservice.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Cliente> criar(@Valid @RequestBody ClienteRequest request){
        Cliente clienteCriado = service.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){
        List<Cliente> clientes = service.listarTodos();
        return  ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        Cliente cliente = service.buscarPorId(id);
        return ResponseEntity.ok(cliente);
    }


}
