# ===============================
# Etapa 1: Build con Maven + Java 21
# ===============================
FROM maven:3.9.13-eclipse-temurin-21 AS build

WORKDIR /app

# Copiar pom.xml y src
COPY pom.xml .
COPY src ./src

# Construir el proyecto (ignora tests)
RUN mvn clean package -DskipTests

# ===============================
# Etapa 2: Runtime con JRE 21
# ===============================
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiar el jar construido
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Variables de entorno
ENV DB_HOST=${DB_HOST} \
    DB_NAME=${DB_NAME} \
    DB_USER=${DB_USER} \
    DB_PASSWORD=${DB_PASSWORD} \
    DB_PORT=${DB_PORT} \
    PORT=${PORT} \
    SPRING_MAIL_HOST=${SPRING_MAIL_HOST} \
    SPRING_MAIL_PORT=${SPRING_MAIL_PORT} \
    SPRING_MAIL_USERNAME=${SPRING_MAIL_USERNAME} \
    SPRING_MAIL_PASSWORD=${SPRING_MAIL_PASSWORD}

# ===============================
# Entry point: validar DB antes de iniciar Spring
# ===============================
COPY wait-for-db.sh wait-for-db.sh
RUN chmod +x wait-for-db.sh

ENTRYPOINT ["./wait-for-db.sh", "app.jar"]