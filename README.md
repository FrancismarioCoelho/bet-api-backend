# betaApi

Este projeto é uma API desenvolvida com Spring Boot, projetada para seguir uma arquitetura limpa que separa claramente a lógica de negócios da infraestrutura.

## Tecnologias Utilizadas

- **Java**: Versão 22
- **Spring Boot**: Versão 3.3.2
- **Banco de Dados**: PostgreSQL

## Estrutura do Projeto

```txt
betaApi
│
├── .idea
│
├── .mvn
│
├── docker
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── br.com.betaApi
│   │   │       ├── application
│   │   │       ├── core
│   │   │       │   ├── person
│   │   │       │   ├── role
│   │   │       │   └── user
│   │   │       ├── shared
│   │   │       │   ├── dto
│   │   │       │   └── util
│   │   │       ├── domain
│   │   │       │   ├── model
│   │   │       │   │   ├── address
│   │   │       │   │   ├── person
│   │   │       │   │   │   └── aggregates
│   │   │       │   │   ├── user
│   │   │       │   │   │   └── aggregates
│   │   │       │   │       └── role
│   │   │       ├── service
│   │   │       │   ├── roles
│   │   │       │   └── users
│   │   │       ├── infrastructure
│   │   │       │   ├── exceptionHandler
│   │   │       │   └── repository
│   │   │       └── presentation
│   │   │           └── controller
│   │   │               ├── role
│   │   │               │   └── RoleController
│   │   │               └── user
│   │   │                   └── UserController
│   │   └── resources
│   │       ├── db
│   │       │   └── migration
│   │       └── application.properties
│   └── test
│       └── java
│           └── (test files structure similar to main)
├── README.md
└── (other root files)


 


 