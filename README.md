# Meu Primeiro Projeto em Java: To-Do List

Este é o meu primeiro projeto desenvolvido em Java, utilizando o framework Spring Boot. Trata-se de uma aplicação web simples de "To-Do List" (Lista de Tarefas) que permite gerenciar suas tarefas diárias.

## Funcionalidades Atuais

* **Adicionar Tarefas**: Crie novas tarefas com uma descrição.
* **Concluir/Desfazer Tarefas**: Marque tarefas como concluídas ou desfaça a conclusão.
* **Excluir Tarefas**: Remova tarefas da lista.
* **Armazenamento em Memória**: Utiliza o banco de dados H2 em memória, o que significa que as tarefas são perdidas ao reiniciar a aplicação.

## Tecnologias Utilizadas

* **Java 17**
* **Spring Boot**: Framework para facilitar o desenvolvimento de aplicações Java.
* **Spring Data JPA**: Para interação com o banco de dados.
* **H2 Database**: Banco de dados em memória para desenvolvimento.
* **Thymeleaf**: Motor de template para as páginas web.
* **Maven**: Ferramenta de gerenciamento de projetos e dependências.
* **Bootstrap 5**: Para estilização básica da interface.

## Como Abrir e Executar o Projeto

Para rodar este projeto na sua máquina, siga os passos abaixo:

### Pré-requisitos

Certifique-se de ter instalado em sua máquina:

* **Java Development Kit (JDK) 17** ou superior.
* **Maven** (gerenciador de projetos, embora o projeto inclua o Maven Wrapper `mvnw`).

### Passos para Executar

1.  **Clone o repositório** (ou certifique-se de ter todos os arquivos do projeto em seu diretório local).
2.  **Navegue até o diretório raiz do projeto** no seu terminal (onde se encontra o arquivo `pom.xml`).
3.  **Conceda permissão de execução ao Maven Wrapper**:
    ```bash
    chmod +x mvnw
    ```
4.  **Construa o projeto**: Este comando irá compilar o código e baixar as dependências.
    ```bash
    ./mvnw clean install
    ```
5.  **Execute a aplicação Spring Boot**:
    ```bash
    ./mvnw spring-boot:run
    ```
    Alternativamente, após a construção, você pode executar o arquivo JAR diretamente:
    ```bash
    java -jar target/to-do-list-0.0.1-SNAPSHOT.jar
    ```

### Acessando a Aplicação

Após o aplicativo iniciar com sucesso (você verá logs no terminal), abra seu navegador e acesse:

* **To-Do List**: `http://localhost:8080/tasks`

### Acessando o Console do H2 (Opcional)

Durante o desenvolvimento, você pode acessar o console do banco de dados H2 para visualizar os dados diretamente:

* **H2 Console**: `http://localhost:8080/h2-console`
    * **JDBC URL**: `jdbc:h2:mem:todolistdb`
    * **User Name**: `sa`
    * **Password**: (deixe em branco)

---

Desenvolvido por Ranilton.
