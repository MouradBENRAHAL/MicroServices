package twin.balade_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
@EnableEurekaClient
@SpringBootApplication
@RestController
@EnableFeignClients
public class BaladeMicroservceApplication {

    @GetMapping("/balade/test")
    public String user_balade_test(@RequestHeader("id") String id,@RequestHeader("role") String role) {
     return "id:"+ id +"  role:"+role;
    }

    @GetMapping("/auth/login")
    public String auth() {
        return "Hello authentification";
    }
	public static void main(String[] args) {
		SpringApplication.run(BaladeMicroservceApplication.class, args);
		
		System.out.println("wooooooork");
		
	}

}
