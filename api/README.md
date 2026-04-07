# Aluno Online API RESTFUL

 Repositório do projeto **Aluno Online API RESTFUL**. Esta é uma API RESTful desenvolvida em Java com Spring Boot, projetada para gerenciar os cadastros de alunos e professores de uma instituição de ensino.

## Explicação do Projeto

O **Aluno Online API RESTFUL** é um sistema back-end que fornece operações de CRUD (Criar, Ler, Atualizar e Deletar) para entidades fundamentais de uma universidade: **Alunos** e **Professores**. 

A API permite que clientes (como aplicações web ou até mesmo ferramentas como o Insomnia) consumam esses dados através de requisições HTTP padrão, recebendo as respostas no formato JSON.

---

## Descrição da Arquitetura Utilizada

O projeto foi construído utilizando a clássica **Arquitetura em Camadas (Layered Architecture)**, um padrão altamente recomendado para aplicações Spring Boot, pois promove a separação de responsabilidades (SoC - Separation of Concerns), facilitando a manutenção, testes e escalabilidade.

As camadas do projeto estão divididas da seguinte forma:

1. **Camada de Apresentação / REST (Controllers)**
   - **O que faz:** É a porta de entrada da API. Recebe as requisições HTTP (GET, POST, PUT, DELETE), mapeia as URLs (endpoints), extrai os parâmetros/corpos das requisições e delega o processamento para a camada de serviço. Ao final, retorna a resposta HTTP adequada (ex: `200 OK`, `201 CREATED`, `204 NO CONTENT`).
   - **Onde encontrar:** Pacote `br.com.alunoonline.api.controller`

2. **Camada de Negócios (Services)**
   - **O que faz:** O "coração" da aplicação. Contém todas as regras de negócios, validações e lógicas de processamento. Ela é chamada pelos Controllers e, se precisar interagir com o banco de dados, chama a camada de Repositórios.
   - **Onde encontrar:** Pacote `br.com.alunoonline.api.service`

3. **Camada de Persistência (Repositories)**
   - **O que faz:** Responsável pela comunicação direta com o banco de dados. Utiliza o Spring Data JPA para abstrair a complexidade do SQL, fornecendo métodos prontos (`save`, `findAll`, `findById`, `deleteById`) através de interfaces.
   - **Onde encontrar:** Pacote `br.com.alunoonline.api.repository`

4. **Camada de Entidades (Models)**
   - **O que faz:** Representa os dados da aplicação e o mapeamento objeto-relacional (ORM). Cada classe desta camada é mapeada para uma tabela no banco de dados.
   - **Onde encontrar:** Pacote `br.com.alunoonline.api.model`

---

## Detalhamento do Código

### Tecnologias e Dependências Principais
- **Java:** Linguagem de programação.
- **Spring Boot:** Framework que facilita a configuração e publicação da aplicação.
- **Spring Web:** Para a criação dos endpoints REST (`@RestController`, `@RequestMapping`, etc).
- **Spring Data JPA:** Para a persistência de dados utilizando o padrão Repository.
- **Lombok:** Biblioteca utilizada para reduzir o código boilerplate (como getters, setters e construtores) através de anotações como `@Data`, `@AllArgsConstructor` e `@NoArgsConstructor`.

### Entidades (Models)
* **`Aluno`**: Mapeada para a tabela `aluno`. Possui as propriedades: `id` (Chave Primária Autoincrementada), `nome`, `cpf` e `email`.
* **`Professor`**: Mapeada para a tabela `professor`. Possui as propriedades: `id` (Chave Primária Autoincrementada), `nome`, `cpf` e `email`.

### Endpoints (APIs Disponíveis)

#### Alunos (`/alunos`)
| Método | Endpoint | Descrição | Status de Sucesso |
| ------ | -------- | --------- | ----------------- |
| `POST` | `/alunos` | Cadastra um novo aluno no banco de dados. | `201 CREATED` |
| `GET` | `/alunos` | Retorna a lista de todos os alunos cadastrados. | `200 OK` |
| `GET` | `/alunos/{id}` | Busca os detalhes de um aluno específico através do seu ID. | `200 OK` |
| `PUT` | `/alunos/{id}` | Atualiza os dados (nome, cpf, email) de um aluno existente. | `204 NO CONTENT` |
| `DELETE`| `/alunos/{id}` | Remove um aluno do banco de dados pelo seu ID. | `204 NO CONTENT` |

#### Professores (`/professor`)
| Método | Endpoint | Descrição | Status de Sucesso |
| ------ | -------- | --------- | ----------------- |
| `POST` | `/professor` | Cadastra um novo professor no banco de dados. | `201 CREATED` |
| `GET` | `/professor` | Retorna a lista de todos os professores cadastrados. | `200 OK` |
| `GET` | `/professor/{id}`| Busca os detalhes de um professor específico através do seu ID. | `200 OK` |
| `PUT` | `/professor/{id}`| Atualiza os dados de um professor existente. | `204 NO CONTENT` |
| `DELETE`| `/professor/{id}`| Remove um professor do banco de dados pelo seu ID. | `204 NO CONTENT` |

> **Nota de Tratamento de Erros:** Nos métodos de atualização (PUT), caso o `id` fornecido não exista no banco de dados, a API foi construída para lançar uma exceção de status `404 NOT FOUND`.


### Print relacionado ao banco de dados dbeaver com as tabelas: professor e aluno.
<img width="1366" height="768" alt="image1" src="https://github.com/user-attachments/assets/3eb1b7d2-f6f1-4244-a5c7-fb0416a8ed08" />


---


A aplicação, por padrão, iniciará no endereço: `http://localhost:8080`.
