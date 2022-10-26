package com.esprit.microservices.advertisement.services;

import com.esprit.microservices.advertisement.Entity.Advertisement;
import com.esprit.microservices.advertisement.Entity.Review;
import com.esprit.microservices.advertisement.Repository.AdvertisementRepository;
import com.esprit.microservices.advertisement.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AdvertisementServices {
    @Autowired
    private AdvertisementRepository pr;
    @Autowired
    ReviewServices rs;
    @Autowired
    private ReviewRepository Revrep;

    public List<Advertisement> GetAllAdvertisement(){
        return pr.findAll();
    }

    public Advertisement AddAdvertisement(Advertisement p){
        Advertisement rs ;
        
        rs= pr.save(p);
        return rs ;
    }
    public void DeleteAdvertisement(int id){
        pr.deleteById(id);
    }

    public Advertisement UpdateAdvertisement(Advertisement p){

        return pr.save(p);
    }

}
