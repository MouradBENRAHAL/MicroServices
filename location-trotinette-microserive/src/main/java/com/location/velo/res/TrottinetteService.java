package com.location.velo.res;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="trottinette-service")
public interface TrottinetteService {
	@GetMapping("/trotti/trottinette/retrieve-Produit/{id}")
	public Trottinette findTroittinetteById(@PathVariable(name="id") Long id);

	 @GetMapping({"/trotti/trottinette/AllProd"})
		public List<Trottinette> findAllTroittinette();

}
