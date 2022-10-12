package org.esprit.controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.esprit.entite.Categorie;
import org.esprit.entite.Trottinette;
import org.esprit.repositorie.CategorieRepo;
import org.esprit.repositorie.TrottinetteRepo;
import org.esprit.service.CategorieService;
import org.esprit.service.TrottinetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@CrossOrigin 
public class TrottinetteController {
	
	@Autowired
	TrottinetteService ts;
@Autowired
	TrottinetteRepo tr;
	@Autowired
	CategorieService cs;
	@Autowired
	CategorieRepo cr;
	 @Autowired
	ServletContext context;
	 private String title ="Hello , I m the candidate Microservice";
		
		
		
		
		
		@RequestMapping("/hello")
		public String sayHello(){
			System.out.println(title);
			return title;
		}
	 @GetMapping({"/AllProd"})
	    public List<Trottinette> GetAllTrot(){
	        return ts.GetAllTrottinettes();
	    }


	    @PostMapping("/Addprod")
	    @ResponseBody
	    public Trottinette addProduit (@RequestPart("file") MultipartFile file,
	                                 @RequestParam("trottinette") String Trottinette /*@RequestParam("nomcat") String nomcat*/) throws JsonParseException, JsonMappingException, Exception
	    {

	        return ts.addProduit(file,Trottinette/*nomcat*/);
	    }

	    @PostMapping("/AddprodCat/{idprod}/{idcat}")
	    @ResponseBody
	    @Transactional
	    public void affecterCatProduit (@PathVariable("idprod") int idtro ,@PathVariable("idcat") Integer idcat)
	    {
	     Categorie cat =  cr.findById(idcat).orElse(null);
	     Trottinette tro = tr.findById(idtro).orElse(null);
	     tro.setCategorie(cat);
	    }

	    @PutMapping("/modify-Produit/{id}")
	    @ResponseBody
	    public Trottinette modifyClient(@RequestPart("file") MultipartFile file,
	                                @RequestParam("trottinette") String Produit, @PathVariable("id") int ProduitId) throws Exception {
	        return ts.UpdateTrottinette(file,Produit,ProduitId);
	    }

	    @DeleteMapping("/remove-Produit/{id}")
	    @ResponseBody
	    public void DeleteClient( @PathVariable("id") int trittinetteId) {
	    	ts.deleteTrottinette(trittinetteId);
	    }

	    @GetMapping("/retrieve-Produit/{id}")
	    @ResponseBody
	    public Trottinette modifyClient( @PathVariable("id") int TrotID) {
	        return ts.retrieveTrottinette(TrotID);
	    }

	    @GetMapping(path="/Imgarticles/{id}")
	    public byte[] getPhoto(@PathVariable("id") int id) throws Exception{
	        Trottinette tro   = tr.findById(id).get();


	            return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+( tro).getImage()/*+personnel.getCartegrise()+personnel.getPermis()*/));


	    }


}
