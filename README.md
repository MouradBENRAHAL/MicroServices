# Spring Boot "Microservice" Trottinette
C'est un exemple d'application Java / Maven / Spring Boot (version 27.5) qui peut être utilisée comme point de départ pour créer un microservice complet .

## Introduction Generale
### The architecture is composed by :
* [micro-eureka-server]: Serveur de découverte Eureka
* [micro-api-getway]: Spring cloud Gateway vise à fournir un moyen simple mais efficace d'acheminer vers les API et de leur fournir des préoccupations transversales telles que : la sécurité, la surveillance/les métriques et la résilience.
* [micro-auth-server]: Service REST simple créé avec NodeJS', MongoDb à utiliser comme service d'authentification
* [micro-trottinette-server]: Service REST simple créé avec Spring Boot, Spring Data JPA, MySQL à utiliser comme un service de ressources
* [micro-balade-server]: Service REST simple créé avec Spring Boot, Spring Data JPA, Postgresql à utiliser comme un service de ressources
* [micro-location-server]: Service REST simple créé avec Spring Boot, Spring Data JPA, H2 à utiliser comme un service de ressources
* [micro-association-server]: Service REST simple créé avec Spring Boot, Spring Data JPA, MySQL à utiliser comme un service de ressources
* [micro-evenement-server]: Service REST simple créé avec Spring Boot, Spring Data JPA, MySQL à utiliser comme un service de ressources 
* [micro-poste-server]: Service REST simple créé avec Spring Boot, Spring Data JPA, MySQL à utiliser comme un service de ressources
### Outils dont vous aurez besoin
* Maven 3.0+ est votre outil de construction
* Votre IDE préféré mais nous vous recommanderons STS-4-4.4.1 version.
* Serveur MySQL/Postgresql *JDK 1.8+
### Processus d'exécution du microservice :
* Nous devons d'abord exécuter le "service eureka"
* Deuxièmement, nous devons exécuter auth-service
* Troisièmement, nous devons exécuter les autres micros services
* Enfin, nous devons exécuter gateway-service,
## Eureka Service
Eureka Server est une application qui contient les informations sur toutes les applications de service client. Chaque micro service s'enregistrera sur le serveur Eureka et le serveur Eureka connaît toutes les applications client exécutées sur chaque port et adresse IP. Eureka Server est également connu sous le nom de Discovery Server.

1

@EnableEurekaServer @SpringBootApplication public class SpringEurekaServerApplication {

public static void main(String[] args) {
    SpringApplication.run(SpringEurekaServerApplication.class, args);
}
}

## API Gateway
Spring Cloud Gateway est la mise en œuvre de la passerelle API par l'équipe Spring Cloud au-dessus de l'écosystème réactif Spring. Il se compose des blocs de construction suivants- Route : route le bloc de construction de base de la passerelle. Cela consiste en IDENTIFIANT URI de destination Collection de prédicats et collection de filtres Une route est mise en correspondance si le prédicat agrégé est vrai.

Au niveau du pom.xml de l’application Gateway,
org.springframework.boot spring-boot-starter-security org.springframework.cloud spring-cloud-starter-openfeign
Dans la classe main du projet, ajouter l’annotation @EnaleFeignClients
@EnableFeignClient("com.clientui") @EnableEurekaClient @SpringBootApplication public class ApiGateway2Application {

}

## Dockerfile
Les images Docker sont un élément important du travail avec le moteur Docker.  créer un fichier image pour l’application.

Exemple Dockerfile
FROM java:8 EXPOSE 8089 COPY /target/test-0.0.1-SNAPSHOT.jar test.jar ENTRYPOINT ["java","jar", "test.jar"]

## Docker-compose
Dans un fichier nommé docker-compose.yml, ajouter le script d’automatisation. Ce script permet de faire le build, le run ... et d’autres configurations relatives aux conteneurs Docker.

