package twin.balade_microservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import twin.balade_microservice.model.Trottinette;


@FeignClient(name="trottinette-service")
public interface TrottinetteService {
	@GetMapping("/trotti/trottinette/retrieve-Produit/{id}")
	public Trottinette findTroittinetteById(@PathVariable(name="id") int id);

}

