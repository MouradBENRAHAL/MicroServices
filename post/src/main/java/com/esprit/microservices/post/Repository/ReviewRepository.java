package com.esprit.microservices.post.Repository;

import com.esprit.microservices.post.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
