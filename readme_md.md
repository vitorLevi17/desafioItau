# Desafio Spring Boot - API de Transações e Estatísticas

Este projeto é uma aplicação Spring Boot que fornece uma API REST para gerenciamento de transações e cálculo de estatísticas. 

## Pré-requisitos

Para construir e executar esta aplicação, você precisará ter instalado em sua máquina:

*   **Java Development Kit (JDK):** Versão 21 (como especificado no `pom.xml` e `Dockerfile`).
*   **Docker:** (Opcional) Caso deseje executar a aplicação em um container.

*Nota: Não é necessário ter o Maven instalado globalmente, pois o projeto utiliza o Maven Wrapper (`mvnw`), que baixará a versão correta do Maven automaticamente.*

## Como construir e executar localmente (via Terminal)

### 1. Clonar ou extrair o projeto
Certifique-se de que você está no diretório raiz do projeto (onde o arquivo `pom.xml` e `mvnw` estão localizados).

### 2. Construir o projeto
Use o Maven Wrapper para compilar o código, rodar os testes e empacotar a aplicação em um arquivo `.jar`.

**No Linux ou macOS:**
```bash
./mvnw clean package
```

**No Windows (Prompt de Comando ou PowerShell):**
```cmd
mvnw.cmd clean package
```

Isso gerará o arquivo executável em `target/desafio-0.0.1-SNAPSHOT.jar`.

### 3. Executar a aplicação
Após a construção bem-sucedida, você pode iniciar a aplicação Spring Boot usando o comando `java -jar` ou através do próprio plugin do Maven.

**Usando o Maven Wrapper:**
```bash
# Linux/macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

**Ou executando diretamente o arquivo .jar:**
```bash
java -jar target/desafio-0.0.1-SNAPSHOT.jar
```

A aplicação iniciará o servidor embutido (Tomcat) e, por padrão, estará acessível em `http://localhost:8080`.

---

## Como construir e executar usando Docker

O projeto já inclui um `Dockerfile` configurado para realizar o *build* da aplicação e gerar uma imagem leve para execução.

### 1. Construir a imagem Docker
No diretório raiz do projeto, execute o comando abaixo para construir a imagem Docker. Você pode dar o nome que preferir, aqui usaremos `desafio-app`:

```bash
docker build -t desafio-app .
```
*Este comando utilizará a imagem especificada no Dockerfile para compilar o código e, em seguida, copiará apenas o `.jar` gerado para uma imagem final contendo apenas o JRE 21, otimizando o tamanho.*

### 2. Executar o container
Uma vez que a imagem foi criada, execute o container mapeando a porta 8080 do container para a porta 8080 da sua máquina host:

```bash
docker run -p 8080:8080 desafio-app
```

A aplicação estará acessível em `http://localhost:8080`.

## Documentação da API (Swagger / OpenAPI)

A aplicação inclui a dependência `springdoc-openapi-starter-webmvc-ui`. 
Com a aplicação em execução, você pode acessar a interface interativa do Swagger para testar os endpoints de transações e estatísticas navegando para:

**[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)**