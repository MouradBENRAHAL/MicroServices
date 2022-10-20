FROM openjdk:8-jdk-alpine
EXPOSE 8087
ADD target/post-0.0.1-SNAPSHOT.jar post.jar
ENTRYPOINT ["java","-jar","/post.jar"]