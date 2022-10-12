FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/Trottinette-0.0.1-SNAPSHOT.jar trottinette.jar
ENTRYPOINT ["java","-jar","/trottinette.jar"]