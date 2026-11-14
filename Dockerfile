# Etapa 1: compilar el proyecto con Maven y Java 17
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests

# Etapa 2: imagen final solo con el JAR
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/cotizacion-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
