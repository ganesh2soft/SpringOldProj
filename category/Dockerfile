FROM maven:3.8.4-openjdk-17 as maven-builder
COPY src /category/src
COPY pom.xml /category


RUN mvn -f /category/pom.xml clean package -DskipTests
RUN echo ${PWD}

FROM openjdk:17-alpine

RUN echo ${PWD} 

COPY --from=maven-builder /category/target/category*.jar /category/category.jar
WORKDIR /category
RUN echo ${PWD} 
EXPOSE 9700
ENTRYPOINT ["java","-jar","category.jar"]