package com.esprit.microservices.advertisement.Repository;

import com.esprit.microservices.advertisement.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
