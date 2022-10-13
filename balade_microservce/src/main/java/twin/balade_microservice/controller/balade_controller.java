package twin.balade_microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import twin.balade_microservice.entity.Balade;
import twin.balade_microservice.service.Balade_service;

@RestController
public class balade_controller {

	@Autowired
	private Balade_service balade_service;
	
	 @PostMapping("add_balade")
	    public Balade add_balade( @RequestBody Balade balade) {
	        return balade_service.add_balade(balade);
	    }
	 
	 @GetMapping("get_balade")
	 public Page<Balade> get_all_balade( @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size,@RequestParam(required = false) String search) {
		Pageable paging = PageRequest.of(page, size);
	return balade_service.get_all_balade(paging,search);
	         
	    }
	 @DeleteMapping("deletebalde/{id}")
	 public void delete_balade( @PathVariable Long id ) {
	  balade_service.delete_balade(id);
	        
	    }
	 @PutMapping("updatebalade")
	 public Balade update_balade( @RequestBody Balade balade) {
	 return balade_service.update_balade(balade);
	        
	    }
	 
	 @GetMapping("getbaladebyid/{id}")
	 public Balade find_balade_byid( @PathVariable Long id) {
	 return balade_service.find_balade_byid(id);
	        
	    }
}
