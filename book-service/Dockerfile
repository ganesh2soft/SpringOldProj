FROM maven:3.8.4-openjdk-17 as maven-builder
COPY src /book-service/src
COPY pom.xml /book-service

RUN mvn -f /book-service/pom.xml clean package -DskipTests
FROM openjdk:17-alpine

COPY --from=maven-builder book-service/target/book-service.jar /book-service/book-service.jar
WORKDIR /book-service

EXPOSE 9001
ENTRYPOINT ["java","-jar","book-service.jar"]