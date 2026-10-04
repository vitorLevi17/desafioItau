#Compilar projeto
FROM maven:3.9-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -e -B -DskipTests package

# Executar o projeto
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

#Só copia o .jar gerado no final do build
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]