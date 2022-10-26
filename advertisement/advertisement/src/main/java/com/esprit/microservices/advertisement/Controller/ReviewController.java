package com.esprit.microservices.advertisement.Controller;

import com.esprit.microservices.advertisement.Entity.Advertisement;
import com.esprit.microservices.advertisement.Entity.Review;
import com.esprit.microservices.advertisement.Repository.AdvertisementRepository;
import com.esprit.microservices.advertisement.Repository.ReviewRepository;
import com.esprit.microservices.advertisement.services.AdvertisementServices;
import com.esprit.microservices.advertisement.services.ReviewServices;
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


}
