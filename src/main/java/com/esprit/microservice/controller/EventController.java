package com.esprit.microservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservice.entity.Event;
import com.esprit.microservice.repsotory.EventRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EventController {
	

	  @Autowired
	  EventRepository eventRepository;
	  

	  @GetMapping("/events")
	  public ResponseEntity<List<Event>> getAllEvents() {
	    try {
	      List<Event> events = new ArrayList<Event>();
	      
	      eventRepository.findAll().forEach(events::add);
	     

	      if (events.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(events, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  @GetMapping("/event/{id}")
	  public ResponseEntity<Event> getTutorialById(@PathVariable("id") int id) {
	    Optional<Event> eventData = eventRepository.findById(id);

	    if (eventData.isPresent()) {
	      return new ResponseEntity<>(eventData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @PostMapping("/event")
	  public ResponseEntity<Event> createTutorial(@RequestBody Event ev) {
	    try {
	      Event event = eventRepository
	          .save(ev);
	      return new ResponseEntity<>(event, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @PutMapping("/event/{id}")
	  public ResponseEntity<Event> updateEvent(@PathVariable("id") int id, @RequestBody Event e) {
	    Optional<Event> eventlData =eventRepository.findById(id);

	    if (eventlData.isPresent()) {
	      Event event = eventlData.get();
	      event.setTitle(e.getTitle());
	      event.setDescription(e.getDescription());
	      event.setImage(e.getImage());
	      return new ResponseEntity<>(eventRepository.save(event), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @DeleteMapping("/event/{id}")
	  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") int id) {
	    try {
	    	eventRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
