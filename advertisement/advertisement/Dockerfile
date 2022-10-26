FROM openjdk:8-jdk-alpine
EXPOSE 8087
ADD target/advertisement-0.0.1-SNAPSHOT.jar advertisement.jar
ENTRYPOINT ["java","-jar","/advertisement.jar"]