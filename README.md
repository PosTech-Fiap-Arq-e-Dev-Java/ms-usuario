# Microsserviço de Usuário - Projeto Java Spring Boot com MySQL + Docker Compose

Este projeto é um microsserviço responsável pela gestão de usuários (clientes e parceiros) em um sistema de restaurantes. Nesta fase ele opera de forma independente, mas compartilha o mesmo banco de dados MySQL utilizado pelo microsserviço MS-LOGIN, facilitando a integração futura entre os serviços.

## 🛠 Tecnologias utilizadas

- Java 17
- Spring Boot
- Maven
- MySQL (compartilhado via rede Docker)
- Docker & Docker Compose
- Lombok
- OpenAPI/Swagger
- Spring Data JPA

## 📁 Estrutura do Projeto

- `app`: aplicação Spring Boot
- `Dockerfile`: imagem da aplicação
- `wait-for-it.sh`: script que aguarda o banco de dados estar pronto antes de subir a aplicação
- `entrypoint.sh`: ponto de entrada para inicialização segura da aplicação

---

## ⚙️ Pré-requisitos

Certifique-se de ter os seguintes softwares instalados:


- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

---

## 📦 Principais arquivos

| Arquivo              | Descrição                                                                |
|----------------------|--------------------------------------------------------------------------|
| `Dockerfile`         | Define a imagem da aplicação Spring Boot                                 |
| `wait-for-it.sh`     | Script que aguarda o MySQL estar disponível antes de iniciar a aplicação |
| `application.yml`    | Configurações do Spring Boot, incluindo porta e datasource               |
| `entrypoint.sh`      | Script de entrada que executa o JAR da aplicação                         |
| `pom.xml`            | Gerenciador de dependências Maven                                        |

---

## ▶️ Como executar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/PosTech-Fiap-Arq-e-Dev-Java/ms-usuario
cd ms-usuario

```
### 2. Compile a aplicação com o Maven

```bash
./mvnw clean package

```
### 3. Dê permissão de execução ao script de espera

```bash
chmod +x wait-for-it.sh
chmod +x entrypoint.sh

```
### 4. Faça o clone do docker-compose

### 5. Suba o docker-compose contendo as três aplicações e o banco de dados

```bash
docker-compose up -d

````

### 6. Suba o container do ms-usuario

```bash
docker-compose up --build
```

---

## 🔗 Endpoints Disponíveis

| Método   | Caminho                     | Descrição                         |
| -------- | --------------------------- | --------------------------------- |
| `POST`   | `/clientes`                 | Criar um novo cliente             |
| `GET`    | `/clientes?usuario=xxx`     | Consultar cliente por usuário     |
| `PATCH`  | `/clientes/{usuario}`       | Atualizar dados do cliente        |
| `DELETE` | `/clientes/{usuario}`       | Remover cliente                   |
| `POST`   | `/restaurantes`             | Criar um novo restaurante         |
| `GET`    | `/restaurantes?usuario=xxx` | Consultar restaurante por usuário |
| `PATCH`  | `/restaurantes/{usuario}`   | Atualizar dados do restaurante    |
| `DELETE` | `/restaurantes/{usuario}`   | Remover restaurante               |


## 🚀 Documentação API (Swagger)

Para explorar e testar os endpoints do microsserviço de forma visual, acesse a documentação interativa Swagger no link abaixo:

[🌐 Acesse a documentação Swagger](http://localhost:9208/ms-usuario/swagger-ui/index.html)


---

## 🛢️ Conexão com Banco de Dados MySQL


| Configuração | Valor                                                            |
|--------------|------------------------------------------------------------------|
| **Host**     | `container-mysql` (nome do container MySQL criado pelo ms-login) |
| **Porta**    | `3306`                                                           |
| **Usuário**  | `adm123`                                                         |
| **Senha**    | `adm123`                                                         |
| **Database** | `db-tc-grupo8`                                                   |


## 🗄️ Tabelas manipuladas pelo ms-usuario
O microsserviço ms-usuario interage com as seguintes tabelas no banco de dados MySQL compartilhado:

| Tabela           | Operações realizadas                   | Descrição                                                                                   |
| ---------------- | -------------------------------------- | ------------------------------------------------------------------------------------------- |
| `tb_cliente`     | `SELECT`, `INSERT`, `UPDATE`, `DELETE` | Armazena dados cadastrais dos clientes, como nome, usuário, email, telefone e endereço.     |
| `tb_restaurante` | `SELECT`, `INSERT`, `UPDATE`, `DELETE` | Armazena dados cadastrais dos restaurantes, como nome, usuário, email, telefone e endereço. |

---

## ‍💻 Autores

Este projeto faz parte da Pós-graduação em Arquitetura e Desenvolvimento Java da FIAP e implementa um microsserviço de gestão de usuários com documentação OpenAPI e persistência de dados em MySQL, seguindo boas práticas de microsserviços.

- Raysse Geise Alves Cutrim - rayssecutrim@hotmail.com