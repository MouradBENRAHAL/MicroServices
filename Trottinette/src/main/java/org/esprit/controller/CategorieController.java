package org.esprit.controller;

import java.util.List;

import org.esprit.entite.Categorie;
import org.esprit.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class CategorieController {
	@Autowired
	CategorieService cs;
  
    @GetMapping({"/AllCat"})
    public List<Categorie> GetAllCat(){
       return cs.GetAllCategories();
    }


    @PostMapping({"/AddCat"})
    public Categorie AddCategorie(@RequestBody Categorie cat) {
        return cs.AddCategorie(cat) ;
    }

    @PutMapping("/modify-Categorie/{id}")
    @ResponseBody
    public Categorie UpdateCategorie(@RequestBody Categorie c, @PathVariable("id") Integer CategorieId) {
        return cs.UpdateCategorie(c);
    }

    @DeleteMapping("/delete-Categorie/{id}")
    @ResponseBody
    public void UpdateCategorie(@PathVariable("id") Integer CategorieId) {
         cs.DeleteCategorie(CategorieId);
    }

    @GetMapping({"/GetCat/{id}"})
    public Categorie GetCat(@PathVariable("id") Integer CategorieId){
        return cs.retrieveCategorie(CategorieId);
    }


}
