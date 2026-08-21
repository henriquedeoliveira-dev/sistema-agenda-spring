# 📱 API REST — Agenda de Contatos

Projeto desenvolvido em Java com Spring Boot, focado na refatoração de uma aplicação Java Core em memória para uma arquitetura RESTful moderna. O sistema substitui o gerenciamento de coleções manuais (ArrayList) por persistência relacional com Spring Data JPA integrada ao MySQL e disponibiliza documentação interativa com Swagger (OpenAPI).

> 💡 **Nota de Evolução:**
> *Esta versão representa a transição completa da camada de aplicação do console para a Web:*
> - **Persistência de Dados:** Substituição das coleções em memória por tabelas mapeadas via JPA/Hibernate e persistida no banco MySQL.
> - **Comunicação REST:** Troca do menu interativo no Main.java por endpoints HTTP (GET, POST, PUT e DELETE).
> - **Tratamento Centralizado de Exceções:** Mapeamento de exceções personalizadas para respostas padronizadas em JSON com @RestControllerAdvice.
> - **Documentação Automática:** Integração do Swagger UI para teste interativo e visualização dos contratos da API.

## 🚀 Funcionalidades

- **Adicionar Contato:** Permite cadastrar nome, telefone e e-mail (com validações @Valid e @NotBlank)
- **Listar Contatos:** Exibe todos os contatos salvos em MySQL de forma limpa (com tratamento para lista vazia).
- **Consultar por Nome:** Busca flexível e inteligente utilizando trechos do nome e ignorando letras maiúsculas ou minúsculas.
- **Excluir Contato:** Permite remover um contato existente da lista através do nome, reorganizando a memória automaticamente.
- **Atualizar Contato:**Permite atualizar um contato existente, inserindo novo nome, email ou telefone
- **Tratamento de Erros Customizados:** Exceções específicas para regras de negócio da aplicação que barram o fluxo antes de digitações desnecessárias.

## 🛠 Tecnologias e Conceitos Utilizados

- Java (Versão 21)
-Spring Boot 4.0.1
- Spring Data JPA & Hibernate
- Banco de Dados MySQL
- Springdoc OpenAPI / Swagger UI
- Lombok
- Maven

## 📂 Arquitetura do Projeto

O projeto adota a estrutura padrão de camadas do ecossistema Spring:

```text
C:.
|   .gitattributes
|   .gitignore
|   HELP.md
|   mvnw
|   mvnw.cmd
|   pom.xml
|   README.md
|
+---.idea
|       .gitignore
|       compiler.xml
|       encodings.xml
|       jarRepositories.xml
|       misc.xml
|       vcs.xml
|       workspace.xml
|
+---.mvn
|   \---wrapper
|           maven-wrapper.properties
|
+---src
|   +---main
|   |   +---java
|   |   |   \---com
|   |   |       \---henriquedeoliveira_dev
|   |   |           \---sistema_agenda_spring
|   |   |               |   SistemaAgendaSpringApplication.java
|   |   |               |
|   |   |               +---controller
|   |   |               |       ContatoController.java
|   |   |               |
|   |   |               +---exception
|   |   |               |       AgendaCheiaException.java
|   |   |               |       ContatoNaoExisteException.java
|   |   |               |       ErroResposta.java
|   |   |               |       GlobalExceptionHandler.java
|   |   |               |       ListaVaziaException.java
|   |   |               |
|   |   |               +---model
|   |   |               |       Contato.java
|   |   |               |
|   |   |               +---repository
|   |   |               |       ContatoRepository.java
|   |   |               |
|   |   |               \---service
|   |   |                       ContatoService.java
|   |   |
|   |   \---resources
|   |       |   application.yaml
|   |       |
|   |       +---static
|   |       \---templates
|   \---test
|       \---java
|           \---com
|               \---henriquedeoliveira_dev
|                   \---sistema_agenda_spring
|                           SistemaAgendaSpringApplicationTests.java
|
\---target
    +---classes
    |   |   application.yaml
    |   |
    |   \---com
    |       \---henriquedeoliveira_dev
    |           \---sistema_agenda_spring
    |               |   SistemaAgendaSpringApplication.class
    |               |
    |               +---model
    |               |       Contato.class
    |               |
    |               \---repository
    |                       ContatoRepository.class
    |
    \---generated-sources
        \---annotations

```

## ⚙ Como Executar o Projeto

1. Certifique-se de ter instalados: JDK 17+; Maven 3.9+; MySQL 8+
3. Clone o repositório:
   ```bash
   git clone https://github.com/henriquedeoliveira-dev/sistema-agenda-spring.git
   ```
3. Abra o projeto na sua IDE favorita (IntelliJ IDEA, Eclipse ou VS Code)
4. Execute a aplicação Maven:
   ```mvn spring-boot:run```
5. Acesse a documentação no navegador:
   Swagger UI: ```http://localhost:8080/swagger-ui.html```
