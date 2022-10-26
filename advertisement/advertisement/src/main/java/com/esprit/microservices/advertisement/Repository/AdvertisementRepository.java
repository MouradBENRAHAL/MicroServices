package com.esprit.microservices.advertisement.Repository;

import com.esprit.microservices.advertisement.Entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {
}
