package org.esprit.service;

import java.util.List;

import org.esprit.entite.Categorie;
import org.esprit.repositorie.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieService {
  
	
	@Autowired
	private CategorieRepo cr;
	
	  public List<Categorie> GetAllCategories(){
	        return cr.findAll();
	    }

	    public Categorie AddCategorie(Categorie c){
	        return cr.save(c);
	    }

	    public void DeleteCategorie(int id){
	         cr.deleteById(id);
	    }

	    public Categorie UpdateCategorie(Categorie c ){
	        return cr.save(c);
	    }

	    public Categorie retrieveCategorie(Integer id) {
	    	Categorie categorie = cr.findById(id).orElse(null);
	        return categorie ;
	    }
}
