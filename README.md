# Sistema de Pagamentos com Microsserviços

Um sistema bancário moderno baseado em arquitetura de microsserviços, desenvolvido com Java e Spring Boot.

## 🏦 Sobre o Projeto

Este projeto implementa um sistema de pagamentos completo utilizando arquitetura de microsserviços, com foco em boas práticas de desenvolvimento, escalabilidade e segurança. O sistema simula operações bancárias reais como criação de contas, depósitos, saques e consultas de saldo.

### Microsserviços Implementados

- **Account Service**: Gerenciamento de clientes e contas bancárias (✅ Concluído)
- **Payment Service**: Processamento de pagamentos e transferências (🔄 Em desenvolvimento)
- **Authentication Service**: Autenticação e autorização (📅 Planejado)

## 🚀 Funcionalidades

### Account Service

- Cadastro e gerenciamento de clientes
- Criação de contas (corrente e poupança)
- Operações de depósito com validação
- Operações de saque com validação de saldo
- Consulta de saldo e informações da conta
- Tratamento de exceções e respostas padronizadas

## 🛠️ Tecnologias Utilizadas

- **Backend**: Java 17
- **Framework**: Spring Boot 3.x
- **Persistência**: Spring Data JPA, Hibernate
- **Banco de Dados**: PostgreSQL
- **Documentação**: Swagger/OpenAPI
- **Containerização**: Docker, Docker Compose
- **Arquitetura**: REST, Microsserviços
- **Padrões**: DTO, Builder, Repository, Service

## 📋 Pré-requisitos

- Java 17+
- Docker e Docker Compose
- Maven

## 🔧 Instalação e Execução

1. Clone o repositório:
```bash
git clone https://github.com/GuilhermeVarellaa/PaymentMicroservice.git
cd PaymentMicroservice
```

2. Inicie os containers com Docker Compose:
```bash
docker-compose up -d
```

3. Acesse a documentação da API:
```
http://localhost:8080/swagger-ui.html
```

## 📚 Documentação da API

A documentação completa da API está disponível através do Swagger UI após iniciar a aplicação.

### Principais Endpoints

#### Clientes
- `POST /api/clientes` - Criar novo cliente
- `GET /api/clientes` - Listar todos os clientes
- `GET /api/clientes/{id}` - Buscar cliente por ID

#### Contas
- `POST /api/contas` - Criar nova conta
- `GET /api/contas` - Listar todas as contas
- `GET /api/contas/{id}` - Buscar conta por ID
- `POST /api/contas/{id}/deposito` - Realizar depósito
- `POST /api/contas/{id}/saque` - Realizar saque
- `GET /api/contas/{id}/saldo` - Consultar saldo

## 🏗️ Arquitetura

O sistema segue uma arquitetura de microsserviços, onde cada serviço é responsável por um domínio específico do negócio:

```
┌─────────────┐     ┌─────────────┐     ┌─────────────┐
│    Client   │────▶│ API Gateway │────▶│    Auth     │
└─────────────┘     └──────┬──────┘     └─────────────┘
                           │
          ┌────────────────┴────────────────┐
          ▼                                  ▼
┌─────────────────┐               ┌─────────────────┐
│ Account Service │◀──────────────▶│ Payment Service │
└────────┬────────┘               └─────────────────┘
         │
         ▼
┌─────────────────┐
│   PostgreSQL    │
└─────────────────┘
```


## 🛣️ Roadmap

- [x] Implementação do Account Service
- [ ] Implementação do Payment Service
- [ ] Implementação do Authentication Service
- [ ] Implementação de API Gateway
- [ ] Implementação de Circuit Breaker
- [ ] Monitoramento com Prometheus e Grafana
- [ ] CI/CD Pipeline

## 👨‍💻 Autor

- **Guilherme Varella** - [LinkedIn](https://www.linkedin.com/in/guilhermervarella/)


⭐️ Desenvolvido como parte do meu portfólio para demonstrar habilidades em desenvolvimento Java, Spring Boot e arquitetura de microsserviços.
