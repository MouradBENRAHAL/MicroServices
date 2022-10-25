package twin.eureka.eurekadiscovery_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class EurekadiscoveryMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekadiscoveryMicroserviceApplication.class, args);
	}

}
