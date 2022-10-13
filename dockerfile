FROM openjdk:11
EXPOSE 8082
ADD target/demo.jar event.jar
ENTRYPOINT ["java","-jar","/event.jar"]