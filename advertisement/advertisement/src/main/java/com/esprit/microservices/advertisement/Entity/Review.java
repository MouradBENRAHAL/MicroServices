package com.esprit.microservices.advertisement.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String Titre;
    private String  Description;
    private String image ;


}
