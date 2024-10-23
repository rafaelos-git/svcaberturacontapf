# Serviço de Abertura de Contas

## Descrição do Projeto

Este projeto é um serviço de abertura de contas desenvolvido em Java com Spring Boot, utilizando arquitetura Hexagonal (Ports and Adapters). O serviço segue um fluxo que envolve validação de CPF, consulta de endereço a partir do CEP, e persistência dos dados tanto em um banco de dados relacional (MySQL) quanto em um banco NoSQL (MongoDB). Por fim, as informações da nova conta são enviadas para um tópico Kafka.

## Arquitetura da solução

![Desafio_Santander](https://github.com/user-attachments/assets/36c81587-d0cd-4223-b7ee-03c44a5523ce)

## Fluxo de Execução

1. **Recepção da Requisição**: Uma requisição é feita com `cpfTitular` e `cep`.
2. **Validação de CPF Existente**: A aplicação verifica se já existe uma conta vinculada ao CPF no banco de dados.
3. **Validação de CPF Externo**: Caso não haja uma conta vinculada ao CPF, a aplicação valida o CPF chamando uma API externa de validação de CPFs.
4. **Consulta de Endereço por CEP**: Após o CPF ser validado, a aplicação faz uma requisição a uma API externa para buscar as informações associadas ao CEP fornecido.
5. **Armazenamento de Logs**: As informações da consulta de CEP são registradas em uma coleção MongoDB para fins de auditoria.
6. **Validação de CEP**: Se a consulta de CEP retornar sucesso, o próximo passo é cadastrar a conta no banco de dados MySQL.
7. **Envio de Mensagem Kafka**: Por fim, as informações da nova conta são enviadas para um tópico Kafka para processamento posterior.

## Arquitetura do código

Este projeto segue a arquitetura Hexagonal, com a seguinte estrutura:

- **Adapters**: Contém as implementações das integrações externas, como chamadas às APIs de CPF e CEP.
- **Application**: Contém o core da aplicação e as interfaces (ports) que definem os contratos da lógica de negócios.
- **Config**: Contém as configurações da aplicação, incluindo beans, banco de dados, Kafka, e WireMock.

### Estrutura de Pastas

```
src/
├── adapters
│   ├── in
|       ├── controller
│   ├── out
|       ├── client
|       ├── repository
|       ├── exceptions
├── application
│   ├── core
|       ├── domain
|       ├── usecase
│   └── ports
|       ├── in
|       ├── out
└── config
```

(Insira aqui um diagrama visual da arquitetura hexagonal)

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA** (para integração com o MySQL)
- **Spring Data MongoDB** (para persistência de logs no MongoDB)
- **Kafka** (para envio de eventos)
- **WireMock** (para simular APIs externas)
- **Docker Compose** (para subir os ambientes de MySQL, MongoDB e Kafka)

## Pré-requisitos

Antes de rodar a aplicação, certifique-se de que as seguintes ferramentas estão instaladas em sua máquina:

- Docker
- Docker Compose
- Java 17
- Gradle (ou outro build tool configurado no projeto)

## Subindo a Aplicação

1. **Subir os Contêineres com Docker Compose**:

```bash
docker-compose up -d
```

2. **Compilar e Rodar a Aplicação**:

```bash
./gradlew bootRun
```

3. **Testar as Funcionalidades**:

A aplicação está configurada para rodar localmente na porta `8081`. Utilize uma ferramenta como Postman ou cURL para testar as APIs.

### Exemplo de Requisição

```bash
POST /api/contas
Content-Type: application/json
{
  "cpfTitular": "12345678901",
  "cep": "01001000"
}
```

## APIs Externas Simuladas

As APIs de CPF e CEP são mockadas com **WireMock**. Os mocks estão configurados para retornar respostas predefinidas, garantindo que os testes sejam executados de maneira determinística.

## Logs

As informações de consulta à API de CEP são armazenadas no MongoDB para fins de auditoria.
