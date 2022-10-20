package com.esprit.microservices.post.services;

import com.esprit.microservices.post.Entity.Post;
import com.esprit.microservices.post.Entity.Review;
import com.esprit.microservices.post.Repository.PostRepository;
import com.esprit.microservices.post.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PostServices {
    @Autowired
    private PostRepository pr;
    @Autowired
    ReviewServices rs;
    @Autowired
    private ReviewRepository Revrep;

    public List<Post> GetAllPost(){
        return pr.findAll();
    }

    public Post AddPost(Post p,int idr){
        Post rs ;
        Review r =Revrep.findById(idr).orElse(null);
        p.setReview(r);
        rs= pr.save(p);
        return rs ;
    }
    public void DeletePost(int id){
        pr.deleteById(id);
    }

    public Post UpdatePost(Post p ,int id){
        Review review = Revrep.findById(id).orElse(null);
        p.setReview(review);
        return pr.save(p);
    }
    public Post retrievePost(Integer id) {
        Post Post = pr.findById(id).orElse(null);
        return Post ;
    }
    public Set<Post> Retrivepostdunreview(Integer id) {
        Review r= Revrep.findById(id).orElse(null);
            return r.getPosts() ;
    }
}
