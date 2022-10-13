package com.esprit.microservice.repsotory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.microservice.entity.Event;


@Repository
public interface EventRepository  extends JpaRepository<Event, Integer>{

}
