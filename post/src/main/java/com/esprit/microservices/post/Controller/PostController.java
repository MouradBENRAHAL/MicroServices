package com.esprit.microservices.post.Controller;

import com.esprit.microservices.post.Entity.Post;
import com.esprit.microservices.post.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins="*")
@RestController
public class PostController {
    @Autowired
    PostServices ps;


    @GetMapping({"/allPost"})
    public List<Post> GetAllPost(){
        return ps.GetAllPost();
    }


    @PostMapping({"/AddPost/{id}"})
    public Post AddPost(@RequestBody Post post,@PathVariable("id") int id) {
        return ps.AddPost(post,id);
    }

    @PutMapping("/modify-Post/{id}")
    @ResponseBody
    public Post UpdateCategorie(@RequestBody Post post,@PathVariable("id") int id) {
        return ps.UpdatePost(post,id);
    }

    @DeleteMapping("/delete-Post/{id}")
    @ResponseBody
    public void UpdatePost(@PathVariable("id") int id) {
     ps.DeletePost(id);
    }

    @GetMapping({"/Getpost/{id}"})
    public Post Getpost(@PathVariable("id") Integer id){
        return ps.retrievePost(id);
    }


}
