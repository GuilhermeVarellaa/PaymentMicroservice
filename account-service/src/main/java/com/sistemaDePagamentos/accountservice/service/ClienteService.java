package com.sistemaDePagamentos.accountservice.service;

import com.sistemaDePagamentos.accountservice.dto.ClienteRequest;
import com.sistemaDePagamentos.accountservice.model.Cliente;
import com.sistemaDePagamentos.accountservice.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente cadastrar(ClienteRequest request ) {
        if (repository.existsByCpf(request.getCpf())){
            throw new IllegalArgumentException("CPF já cadastrado");
        }

        Cliente cliente = Cliente.builder()
                .nome(request.getNome())
                .cpf(request.getCpf())
                .email(request.getEmail())
                .telefone(request.getTelefone())
                .build();

        return repository.save(cliente);
    }

    public List<Cliente> listarTodos(){
        return repository.findAll();
    }

    public Cliente buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com ID: " + id));
    }


}
