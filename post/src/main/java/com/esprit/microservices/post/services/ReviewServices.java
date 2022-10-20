package com.esprit.microservices.post.services;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import com.esprit.microservices.post.Entity.Review;
import com.esprit.microservices.post.Repository.ReviewRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.List;

@Service
public class ReviewServices {
    @Autowired
    ServletContext context;
    @Autowired
    private ReviewRepository rp;

    public List<Review> GetAllReviews(){
        return rp.findAll();
    }


    public Review addReview(MultipartFile file , String p) throws JsonParseException, JsonMappingException, Exception{

        System.out.println("Ok .............");
        Review rev = new ObjectMapper().readValue( p, Review.class);
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
        rev.setImage(newFileName);
        return  rp.save(rev) ;
    }
    public Review UpdateReview(MultipartFile file , String p ,int id) throws JsonParseException, JsonMappingException, Exception
    {
        //Produit prod1 = produitDao.findById(id).orElse(null) ;
        System.out.println("Ok .............");
        Review tro = new ObjectMapper().readValue( p, Review.class);
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
        return  rp.save(tro) ;
    }

    public void deleteReview(long id) {
        rp.deleteById((int) id);
    }

    public Review retrieveReview(int id) {
        return rp.findById(id).orElse(null);
    }


}
