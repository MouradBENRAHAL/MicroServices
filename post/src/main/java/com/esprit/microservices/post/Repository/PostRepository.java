package com.esprit.microservices.post.Repository;

import com.esprit.microservices.post.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
