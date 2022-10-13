package com.esprit.microservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class TroutinetApplication {

	public static void main(String[] args) {
		SpringApplication.run(TroutinetApplication.class, args);
	}
	
	/*
	@Bean
	ApplicationRunner init(CandidatReposiory repository)
	{
		return args ->{
			Stream.of("Mariem" , "Sarra" , "Mohamed").forEach(nom->
			{
				repository.save(new Candidat(nom));
			});
			repository.findAll().forEach(System.out::println);
		};
	}*/

}
