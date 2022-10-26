package com.esprit.microservices.advertisement.Controller;

import com.esprit.microservices.advertisement.Entity.Advertisement;
import com.esprit.microservices.advertisement.services.AdvertisementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("api")
public class AdvertisementController {
    @Autowired
    AdvertisementServices ps;


    @GetMapping({"/allAdvertisement"})
    public List<Advertisement> GetAllAdvertisement(){
        return ps.GetAllAdvertisement();
    }


    @PostMapping({"/AddAdvertisement"})
    public Advertisement AddAdvertisement(@RequestBody Advertisement advertisement) {
        return ps.AddAdvertisement(advertisement);
    }

    @PutMapping("/modify-Advertisement/{id}")
    @ResponseBody
    public Advertisement UpdateCategorie(@RequestBody Advertisement advertisement) {
        return ps.UpdateAdvertisement(advertisement);
    }

    @DeleteMapping("/delete-Advertisement/{id}")
    @ResponseBody
    public void UpdateAdvertisement(@PathVariable("id") int id) {
     ps.DeleteAdvertisement(id);
    }




}
