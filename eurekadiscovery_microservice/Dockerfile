FROM openjdk:8
COPY target/eurekadiscovery_microservice-0.0.1-SNAPSHOT.jar  eureka.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/eureka.jar"]
