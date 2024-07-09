FROM maven:3.8.4-openjdk-17 as maven-builder
COPY src /springhellokube/src
COPY pom.xml /springhellokube


RUN mvn -f /springhellokube/pom.xml clean package -DskipTests
RUN echo ${PWD}

FROM openjdk:17-alpine

RUN echo ${PWD} 

COPY --from=maven-builder /springhellokube/target/springhellokube-0.0.1-SNAPSHOT.jar /springhellokube/springhellokube.jar
WORKDIR /springhellokube
RUN echo ${PWD} 
# EXPOSE 9400
ENTRYPOINT ["java","-jar","springhellokube.jar"]