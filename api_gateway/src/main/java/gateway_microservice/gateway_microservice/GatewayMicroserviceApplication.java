package gateway_microservice.gateway_microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@RestController
@EnableEurekaClient
@SpringBootApplication
public class GatewayMicroserviceApplication {

	 @Autowired
	    filter filter;


   @Bean
	public RouteLocator routes (RouteLocatorBuilder builder) {
		return builder.routes()
			.route(r -> r.path("/trotti/auth/**").uri("lb://USER-SERVICE"))

	     	 .route("balade-service", r -> r.path("/trotti/balade/**")
	               .filters(f -> f.filter(filter))
	               .uri("lb://BALADE-SERVICE"))
	     	.route("trottinette-service", r -> r.path("/trotti/trottinette/**")
		               .filters(f -> f.filter(filter))
		               .uri("lb://TROTTINETTE-SERVICE"))
	     	.route("event-service", r -> r.path("/trotti/event/**")
		               .filters(f -> f.filter(filter))
		               .uri("lb://EVENT-SERVICE"))
	     	.route("location-service", r -> r.path("/trotti/locations/**")
		               .filters(f -> f.filter(filter))
		               .uri("lb://LOCATION-VELO"))
	     	.route("post-service", r -> r.path("/trotti/post/**")
		               .filters(f -> f.filter(filter))
		               .uri("lb://REVIEWS-SERVICE"))
			.route("advertisement-service", r -> r.path("/trotti/advertisement/**")
		               .filters(f -> f.filter(filter))
		               .uri("lb://REVIEWS-SERVICE"))
	          .build();

	}


   //@Bean
	//DiscoveryClientRouteDefinitionLocator dynamicRoutes (ReactiveDiscoveryClient rdc ,DiscoveryLocatorProperties dlp) {
	//	return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
	//	}
	public static void main(String[] args) {

		SpringApplication.run(GatewayMicroserviceApplication.class, args);


	}

}
