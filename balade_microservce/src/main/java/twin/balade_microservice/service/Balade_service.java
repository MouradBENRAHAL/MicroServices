package twin.balade_microservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import twin.balade_microservice.entity.Balade;
import twin.balade_microservice.repository.Balade_repository;

@Service
public class Balade_service {
 
	@Autowired
	private Balade_repository balade_repository;
	
	
	public Balade add_balade (Balade balade)
	{
		return balade_repository.save(balade);
	}
	
	public Balade update_balade (Balade balade)
	{
		return balade_repository.save(balade);
	}
	
	public Page<Balade> get_all_balade (Pageable peageble,String search)
	{
		if (search.equals("")) {
			return balade_repository.findAll(peageble);
		}else {
			 List<Balade> mydemande= balade_repository.findAll().stream()
				      .filter(demande ->demande.getDisponible().contains(search) ||
				    		  demande.getTitre().contains(search) || demande.getGuide_accompagnateur().toString().contains(search))
				      .collect(Collectors.toList());
		   int start = (int) peageble.getOffset();
		   int end = (int) ((start + peageble.getPageSize()) > mydemande.size() ? mydemande.size()
				   : (start + peageble.getPageSize()));
		   Page<Balade> mydemandepage = new PageImpl<>(mydemande.subList(start, end),peageble,mydemande.size());
		   
		   return mydemandepage;
		}
		
	}
	
	public Balade find_balade_byid (Long id)
	{
		return balade_repository.findById(id).orElse(null);
	}
	
	public void delete_balade (Long  id)
	{ 
		
		balade_repository.deleteById(id);
	
	}
	
	


}	
