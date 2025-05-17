# Projeto Java Spring Boot com MySQL + Docker Compose Microservice Usuario

Este projeto é um microserviço que cuida da parte de cadastro de usuarios para um sistema de gestão de restaurantes.

---

## Pré-requisitos

Certifique-se de ter os seguintes softwares instalados:

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- [Java 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven](https://maven.apache.org/)

---

## Como executar

### 1. Clone o repositório

git clone https://github.com/FIAP-Pos-Arq-e-Dev-Java/ms-usuario

### 2. Compile a aplicação localmente utilizando maven

./mvnw clean package

### 3. Suba os containers com Docker Compose

docker-compose up --build

### 4. Acesse a aplicação 
##### Obs: Utilizamos portas altas para evitar risco de conflito na hora de executar o projeto

API Spring Boot: http://localhost:9000/ms-usuario/

MySQL:

Host: localhost

Porta: 3307
Usuário: admMsUsuario
Senha: admMsUsuario123
Database: db-ms-usuario




