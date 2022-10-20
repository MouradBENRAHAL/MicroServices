package twin.balade_microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import twin.balade_microservice.entity.Participation;
import twin.balade_microservice.service.participation_service;
@RestController
public class participation_controller {

	
	@Autowired
	private participation_service participation_service ;
	
	
	 @GetMapping("add_participation/{velo_id}/{balade_id}")
	    public Participation add_balade( @PathVariable int velo_id,@PathVariable Long balade_id) {
	        return participation_service.add_balade(velo_id,balade_id);
	        
	    }
}
