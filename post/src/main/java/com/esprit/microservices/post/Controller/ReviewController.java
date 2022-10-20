package com.esprit.microservices.post.Controller;

import com.esprit.microservices.post.Entity.Post;
import com.esprit.microservices.post.Entity.Review;
import com.esprit.microservices.post.Repository.PostRepository;
import com.esprit.microservices.post.Repository.ReviewRepository;
import com.esprit.microservices.post.services.PostServices;
import com.esprit.microservices.post.services.ReviewServices;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin(origins="*")
public class ReviewController {

    @Autowired
    PostServices postServices;
    @Autowired
    PostRepository postRepository;
    @Autowired
    ReviewServices reviewServices;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    ServletContext context;

    @GetMapping({"/AllReview"})
    public List<Review> GetAllReview(){
        return reviewServices.GetAllReviews();
    }
    @GetMapping({"/AllPostRev/{id}"})
    public Set<Post> GetAllReview(@PathVariable("id") int id ){
        return postServices.Retrivepostdunreview(id);
    }


    @PostMapping("/AddReview")
    @ResponseBody
    public Review addReview (@RequestPart("file") MultipartFile file,
                                   @RequestParam("Review") String Trottinette /*@RequestParam("nomcat") String nomcat*/) throws JsonParseException, JsonMappingException, Exception
    {

        return reviewServices.addReview(file,Trottinette);
    }

    @PostMapping("/AddPostReview/{idpost}/{idrev}")
    @ResponseBody
    @Transactional
    public void affecterPOstReview (@PathVariable("idpost") int idpost ,@PathVariable("idrev") Integer idrev)
    {
        Post post =  postRepository.findById(idpost).orElse(null);
        Review review = reviewRepository.findById(idrev).orElse(null);
        post.setReview(review);
    }

    @PutMapping("/modify-Review/{id}")
    @ResponseBody
    public Review modifyClient(@RequestPart("file") MultipartFile file,
                                    @RequestParam("Review") String Review, @PathVariable("id") int ProduitId) throws Exception {
        return reviewServices.UpdateReview(file,Review,ProduitId);
    }

    @DeleteMapping("/remove-Review/{id}")
    @ResponseBody
    public void DeleteClient( @PathVariable("id") long id) {
        reviewServices.deleteReview(id);
    }

    @GetMapping("/retrieve-Review/{id}")
    @ResponseBody
    public Review modifyClient( @PathVariable("id") int id) {
        return reviewServices.retrieveReview(id);
    }

    @GetMapping(path="/Imgarticles/{id}")
    public byte[] getPhoto(@PathVariable("id") int id) throws Exception{
        Review tro   = reviewRepository.findById(id).get();

        return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+( tro).getImage()/*+personnel.getCartegrise()+personnel.getPermis()*/));


    }

}
