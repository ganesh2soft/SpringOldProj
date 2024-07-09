FROM maven:3.8.4-openjdk-17 as maven-builder
COPY src /student-service/src
COPY pom.xml /student-service

RUN mvn -f /student-service/pom.xml clean package -DskipTests
FROM openjdk:17-alpine

COPY --from=maven-builder student-service/target/student-service.jar /student-service/student-service.jar
WORKDIR /student-service

EXPOSE 9003
ENTRYPOINT ["java","-jar","student-service.jar"]


