FROM maven:3.9.13-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
COPY wait-for-db.sh wait-for-db.sh
RUN chmod +x wait-for-db.sh

EXPOSE 8080

ENTRYPOINT ["./wait-for-db.sh"]