package org.esprit.service;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.esprit.entite.Trottinette;
import org.esprit.repositorie.TrottinetteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TrottinetteService {
	
	 @Autowired
	    ServletContext context;
	@Autowired
	private TrottinetteRepo tr;
	  public List<Trottinette> GetAllTrottinettes(){
	        return tr.findAll();
	    }

	    public Trottinette addProduit(MultipartFile file ,String p /*String nomcat*/) throws JsonParseException, JsonMappingException, Exception{
	       // Categorie cat = categorieDao.findByNomCategorie(nomcat)  ;
	        System.out.println("Ok .............");
	        Trottinette tro = new ObjectMapper().readValue( p, Trottinette.class);
	      //  Categorie cat = new ObjectMapper().readValue( nomcat, Categorie.class);
	        boolean isExit = new File(context.getRealPath("/Images/")).exists();
	        if (!isExit)
	        {
	            new File (context.getRealPath("/Images/")).mkdir();
	            System.out.println("mkdir success.............");
	        }
	        String filename = file.getOriginalFilename();
	        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
	        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
	        try
	        {
	            System.out.println("Image");
	            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

	        }catch(Exception e) {
	            e.printStackTrace();
	        }
	       // prod.setCategorie(cat);
	        tro.setImage(newFileName);
	        return  tr.save(tro) ;
	    }

	    public Trottinette UpdateTrottinette(MultipartFile file , String p ,int id) throws JsonParseException, JsonMappingException, Exception
	    {
	         //Produit prod1 = produitDao.findById(id).orElse(null) ;
	        System.out.println("Ok .............");
	        Trottinette tro = new ObjectMapper().readValue( p, Trottinette.class);
	        tro.setId(id);
	        //  Categorie cat = new ObjectMapper().readValue( nomcat, Categorie.class);
	        boolean isExit = new File(context.getRealPath("/Images/")).exists();
	        if (!isExit)
	        {
	            new File (context.getRealPath("/Images/")).mkdir();
	            System.out.println("mkdir success.............");
	        }
	        String filename = file.getOriginalFilename();
	        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
	        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
	        try
	        {
	            System.out.println("Image");
	            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

	        }catch(Exception e) {
	            e.printStackTrace();
	        }
	        // prod.setCategorie(cat);
	        tro.setImage(newFileName);
	        return  tr.save(tro) ;
	    }

	    public void deleteTrottinette(int id) { 
	    	tr.deleteById(id);}


	    public Trottinette retrieveTrottinette(int id) {
	    	Trottinette tro = tr.findById(id).orElse(null);
	        return tro ;
	    }


}
